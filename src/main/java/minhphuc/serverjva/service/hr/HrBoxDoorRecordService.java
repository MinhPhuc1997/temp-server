package minhphuc.serverjva.service.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.config.DataSourceType;
import minhphuc.serverjva.config.DynamicRoutingDataSource;
import minhphuc.serverjva.domain.hr.HrBoxDoorRecord;
import minhphuc.serverjva.mapper.hr.HrBoxDoorRecordMapper;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import minhphuc.serverjva.utils.StringUtils;
import minhphuc.serverjva.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HrBoxDoorRecordService {

    @Autowired
    HrBoxDoorRecordMapper hrBoxDoorRecordMapper;

    public MessageResult saveEntity(HrBoxDoorRecord boxDoorRecord){
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        String uuid = StringUtils.getUUID();
        boxDoorRecord.setRecordID(uuid);
        hrBoxDoorRecordMapper.insert(boxDoorRecord);
        return MessageResult.success(uuid);
    }

    public MessageResult removeEntity(HrBoxDoorRecord boxDoorRecord){
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        if (boxDoorRecord.getRecordID().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để xóa");
        }
        Integer result = hrBoxDoorRecordMapper.deleteById(boxDoorRecord);
        return MessageResult.success(result);
    }

    public MessageResult updateEntity(HrBoxDoorRecord boxDoorRecord){
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        if ( boxDoorRecord.getRecordID().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để cập nhật");
        }
        Integer result = hrBoxDoorRecordMapper.updateById(boxDoorRecord);
        return MessageResult.success(result);
    }

    public List<HrBoxDoorRecord> getEntityList(HrBoxDoorRecord boxDoorRecord){
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);

        if (boxDoorRecord.getDate()==null){
            return hrBoxDoorRecordMapper.selectList(new QueryWrapper<>(boxDoorRecord));
        }
        return hrBoxDoorRecordMapper.selectList(new QueryWrapper<>(boxDoorRecord)
                .ge("ActionTime",boxDoorRecord.getDate()+" 00:00:00")
                .le("ActionTime",boxDoorRecord.getDate()+" 23:59:59"));
    }

    public List<HrBoxDoorRecord> getEntityListByDetail(String personNo,String date,String shiftId){
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        if (date==null || personNo ==null || shiftId==null){
            return new ArrayList<>();
        }
        return hrBoxDoorRecordMapper.selectList(Tools.boxDoorTimeQueryWrapper(personNo,date,shiftId));

    }

    public IPage<HrBoxDoorRecord> getEntityListByPage(PageUtil pageUtil, HrBoxDoorRecord boxDoorRecord) {
        DynamicRoutingDataSource.setDataSource(DataSourceType.JLK);
        if (boxDoorRecord.getDate()==null){
            return hrBoxDoorRecordMapper.selectPage(new Page<HrBoxDoorRecord>(pageUtil.getPage(),pageUtil.getRows()),
                    new QueryWrapper<>(boxDoorRecord));
        }
        return hrBoxDoorRecordMapper.selectPage(new Page<HrBoxDoorRecord>(pageUtil.getPage(),pageUtil.getRows()),
                new QueryWrapper<>(boxDoorRecord)
                .ge("ActionTime",boxDoorRecord.getDate()+" 00:00:00")
                .le("ActionTime",boxDoorRecord.getDate()+" 23:59:59"));
    }

}
