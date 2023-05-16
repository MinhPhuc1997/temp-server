package minhphuc.serverjva.service.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.config.DataSourceType;
import minhphuc.serverjva.config.DynamicRoutingDataSource;
import minhphuc.serverjva.domain.hr.HrWorkShift;
import minhphuc.serverjva.mapper.hr.HrWorkShiftMapper;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import minhphuc.serverjva.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrWorkShiftService {

    @Autowired
    HrWorkShiftMapper hrWorkShiftMapper;

    public MessageResult saveHrWorkShift(HrWorkShift hrWorkShift){
        String uuid = StringUtils.getUUID();
        hrWorkShift.setShiftId(uuid);
        hrWorkShiftMapper.insert(hrWorkShift);
        return MessageResult.success(uuid);
    }

    public MessageResult removeHrWorkShift(HrWorkShift hrWorkShift){
        if (hrWorkShift.getShiftId().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để xóa");
        }
        Integer result = hrWorkShiftMapper.deleteById(hrWorkShift);
        return MessageResult.success(result);
    }

    public MessageResult updateHrWorkShift(HrWorkShift boxDoorRecord){
        if ( boxDoorRecord.getShiftId().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để cập nhật");
        }
        Integer result = hrWorkShiftMapper.updateById(boxDoorRecord);
        return MessageResult.success(result);
    }

    public List<HrWorkShift> getHrWorkShiftList(HrWorkShift hrWorkShift){
        List<HrWorkShift> boxDoorRecords = hrWorkShiftMapper.selectList(new QueryWrapper<>(hrWorkShift));
        return boxDoorRecords;
    }

    public IPage<HrWorkShift> getHrWorkShiftListByPage(PageUtil pageUtil, HrWorkShift hrWorkShift) {
        return hrWorkShiftMapper.selectPage(new Page<HrWorkShift>(pageUtil.getPage(), pageUtil.getRows()), new QueryWrapper<>(hrWorkShift));
    }
}
