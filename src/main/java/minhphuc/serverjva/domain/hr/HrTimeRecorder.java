package minhphuc.serverjva.domain.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel(description = "1.Bù thẻ chấm công")
@TableName("PER_TIMERECORDER_APPLY")
public class HrTimeRecorder {

    @TableId(value = "PER_TIMERECORDER_APPLYOID")
    @ApiModelProperty(value = "Mã khóa chính")
    private String recorderID;

    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value = "PER_ID")
    private String perId;

    @ApiModelProperty(value = "Loại bù thẻ 1: 2:")
    @TableField(value = "APPLY_TYPE")
    private String applyType;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_DATE4")
    private String swipeDate4;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_TIME4")
    private String swipeTime4;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_DATE3")
    private String swipeDate3;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_TIME3")
    private String swipeTime3;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_DATE2")
    private String swipeDate2;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_DATE1")
    private String swipeDate1;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi sáng")
    @TableField(value = "SWIPE_TIME1")
    private String swipeTime1;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Bù thẻ buổi chiều")
    @TableField(value = "SWIPE_TIME2")
    private String swipeTime2;

    @ApiModelProperty(value = "lý do")
    @TableField(value = "REASON")
    private String reason;

    @ApiModelProperty(value = "Tra cứu theo ngày")
    @TableField(exist = false)
    private String date;

}
