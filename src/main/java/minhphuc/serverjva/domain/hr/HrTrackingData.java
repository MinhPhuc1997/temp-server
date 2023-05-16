package minhphuc.serverjva.domain.hr;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HrTrackingData {

    @ExcelProperty(value = "工号")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="PersonNO")
    @ColumnWidth(value = 20)
    private String personNo;

    @ExcelProperty(value = "姓名")
    @ApiModelProperty(value = "Tên nhân viên")
    @TableField(value="personName")
    private String personName;

    @ExcelProperty(value = "出生日期")
    @ApiModelProperty(value = "Ngày sinh nhân viên")
    @TableField(value="birthday")
    private String birthday;

    @ExcelProperty(value = "考勤日期")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="personName")
    private String trackingDate;

    @ExcelProperty(value = "干活时间")
    @ApiModelProperty(value = "Thời gian làm việc")
    @TableField(value="workTime")
    private String workTime;

    @ExcelProperty(value = "休息时间")
    @ApiModelProperty(value = "Thời gian nghỉ trưa")
    @TableField(value="breakTime")
    private String breakTime;

    @ExcelProperty(value = "星期")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String dayOfWeek;

    @ExcelProperty(value = "部门")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String orgName;

    @ExcelProperty(value = "班次")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String shiftName;

    @ExcelProperty(value = "班次")
    @ApiModelProperty(value = "Mã ca làm")
    @TableField(value="shiftId")
    private String shiftId;

    @ExcelProperty(value = "上班时间")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String time1;

    @ExcelProperty(value = "中午下班")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String time2;

    @ExcelProperty(value = "中午上班")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String time3;

    @ExcelProperty(value = "下班")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String time4;

    @ExcelProperty(value = "是否补考勤")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="timeRecord")
    private Integer offset;

    @ExcelProperty(value = "请假小时")
    @ApiModelProperty(value = "Thời gian nghỉ phép")
    @TableField(value="fourghHours")
    private String fourghHours;

    @ExcelProperty(value = "请假类型")
    @ApiModelProperty(value = "Loại phép")
    @TableField(value="fourghName")
    private String fourghName;

    @ExcelProperty(value = "上班时间")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private Float workHours;

    @ExcelProperty(value = "加班时间")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String overTime;

    @ExcelProperty(value = "考勤状态")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private Boolean status;

    @ExcelProperty(value = "备注")
    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="weekday")
    private String note;

}
