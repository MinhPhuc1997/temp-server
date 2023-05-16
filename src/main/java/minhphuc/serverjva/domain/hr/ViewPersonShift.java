package minhphuc.serverjva.domain.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "view nhan vien voi ca lam")
@TableName("view_person_shift")
public class ViewPersonShift {

    @TableField(value="PS_DATE")
    private String trackingDate;

    @TableField(value="PER_ID")
    private String personNo;

    @TableField(value="PER_NAME")
    private String personName;

    @TableField(value="OrgName")
    private String OrgName;

    @TableField(value="organize_fk")
    private String organizeFk;

    @TableField(value="PS_BATTH")
    private String shiftName;

    @TableField(value="BIRTHDAY")
    private String birthday;

    @TableField(value="politics")
    private String politics;

    @TableField(value="PS_INC")
    private Integer psInc;

    @TableField(value="PS_INC")
    private String shiftId;

    @TableField(value="break_split")
    private Integer breakSplit;

    @TableField(value="IS_SELECT1")
    private String isSelect1;

    @TableField(value="IS_SELECT2")
    private String isSelect2;

    @TableField(value="IS_SELECT3")
    private String isSelect3;

    @TableField(value="IS_CrossDay2")
    private String isCrosDay2;

    @TableField(value="PS_MINUUES_A1")
    private Integer psMinuuesA1;

    @TableField(value="PS_MINUUES_A2")
    private Integer psMinuuesA2;

    @TableField(value="PS_MINUUES_A3")
    private Integer psMinuuesA3;

    @TableField(value="PS_MINUUES_B1")
    private Integer psMinuuesB1;

    @TableField(value="PS_MINUUES_B2")
    private Integer psMinuuesB2;

    @TableField(value="PS_MINUUES_B3")
    private Integer psMinuuesB3;

    @TableField(value="PS_MINUUES_C1")
    private Integer psMinuuesC1;

    @TableField(value="PS_MINUUES_C2")
    private Integer psMinuuesC2;

    @TableField(value="PS_MINUUES_C3")
    private Integer psMinuuesC3;

    @TableField(value="PS_REST")
    private Integer psRest;

    @TableField(value="PS_OFFWORK1")
    private String psOffwork1;

    @TableField(value="PS_OFFWORK2")
    private String psOffwork2;

    @TableField(value="PS_OFFWORK3")
    private String psOffwork3;

    @TableField(value="PS_WORKHOUR1")
    private String psWorkHour1;

    @TableField(value="PS_WORKHOUR2")
    private String psWorkHour2;

    @TableField(value="PS_WORKHOUR3")
    private String psWorkHour3;


    @TableField(value="work_hours")
    private Integer workHours;

    @TableField(value="swipe_id")
    private String swipeId;

    @TableField(value="swipe_date1")
    private String swipeDate1;

    @TableField(value="swipe_time1")
    private String swipeTime1;

    @TableField(value="swipe_date2")
    private String swipeDate2;

    @TableField(value="swipe_time2")
    private String swipeTime2;

    @TableField(value="swipe_date3")
    private String swipeDate3;

    @TableField(value="swipe_time3")
    private String swipeTime3;

    @TableField(value="swipe_date4")
    private String swipeDate4;

    @TableField(value="swipe_time4")
    private String swipeTime4;

    @TableField(value="reason")
    private String reason;

}
