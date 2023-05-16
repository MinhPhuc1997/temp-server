package minhphuc.serverjva.domain.hr;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Time;

@Data
@ApiModel(description = "Thông tin ca làm việc")
@TableName("hr_work_shift")
public class HrWorkShift {

    @TableId()
    @ApiModelProperty(value = "Mã ca làm")
    private String shiftId;

    @ApiModelProperty(value = "Mã ca làm")
    private String shiftName;

    @ApiModelProperty(value = "Mã ca làm")
    private String shiftType;

    @ApiModelProperty(value = "Thời gian bắt đầu 1")
    private Time startTime1;

    @ApiModelProperty(value = "Thời gian kết thúc 1")
    private Time endTime1;

    @ApiModelProperty(value = "Thời gian về trễ 1")
    private Integer lateTime1;


    @ApiModelProperty(value = "Thời gian bắt đầu 2")
    private Time startTime2;

    @ApiModelProperty(value = "Thời gian kết thúc 2")
    private Time endTime2;

    @ApiModelProperty(value = "Thời gian về trễ 2")
    private Integer lateTime2;

    @ApiModelProperty(value = "Thời gian về trễ 1")
    private Integer lateTime3;

    @ApiModelProperty(value = "Thời gian bắt đầu 3")
    private Time startTime3;

    @ApiModelProperty(value = "Thời gian kết thúc 3")
    private Time endTime3;

    @ApiModelProperty(value = "Thời gian về trễ 3")
    private Integer lateTime4;

    @ApiModelProperty(value = "Thời gian bắt đầu 4")
    private Time startTime4;

    @ApiModelProperty(value = "Thời gian kết thúc 4")
    private Time endTime4;

    @ApiModelProperty(value = "Thời gian về trễ 4")
    private Integer isOverday;

    @ApiModelProperty(value = "Qua ngày")
    private Integer breakTime;

    @ApiModelProperty(value = "số lượt nghỉ trưa")
    private Integer splitTime;

    @ApiModelProperty(value = "Thời gian về trễ 4")
    private Integer workHours;

}
