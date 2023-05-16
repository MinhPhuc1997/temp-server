package minhphuc.serverjva.mapper.hr;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import minhphuc.serverjva.domain.hr.HrTimeRecorder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface HrTimeRecorderMapper extends BaseMapper<HrTimeRecorder> {

    @Select("SELECT * from PER_TIMERECORDER_APPLY \n" +
            "WHERE (SWIPE_DATE1=#{date} or SWIPE_DATE2=#{date} \n" +
            "or SWIPE_DATE3=#{date} or SWIPE_DATE4=#{date}) AND PER_ID=#{personNo}")
    List<HrTimeRecorder> getTimeRecords(@Param("date") String date,@Param("personNo") String personNo);


}
