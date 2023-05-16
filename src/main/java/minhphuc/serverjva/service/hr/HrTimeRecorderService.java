package minhphuc.serverjva.service.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.domain.hr.HrTimeRecorder;
import minhphuc.serverjva.domain.hr.ViewPersonShift;
import minhphuc.serverjva.mapper.hr.HrTimeRecorderMapper;
import minhphuc.serverjva.model.orther.PMType;
import minhphuc.serverjva.model.response.OffsetArray;
import minhphuc.serverjva.utils.PageUtil;
import minhphuc.serverjva.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HrTimeRecorderService {

    @Autowired
    HrTimeRecorderMapper hrTimeRecorderMapper;
    public List<OffsetArray> getHrTimeRecorderList (String date, String personNo){
        if (personNo==null || date==null){
            return null;
        }
        return Tools.convertOffsetObjectToArray(hrTimeRecorderMapper.getTimeRecords(date,personNo));
    }
    public IPage<HrTimeRecorder> getHrTimeRecorderListByPage(PageUtil pageUtil, HrTimeRecorder hrTimeRecorder) {

        return hrTimeRecorderMapper.selectPage(new Page<HrTimeRecorder>(pageUtil.getPage(), pageUtil.getRows()), new QueryWrapper<>(hrTimeRecorder));
    }

}
