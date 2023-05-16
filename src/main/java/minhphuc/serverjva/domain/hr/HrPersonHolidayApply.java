package minhphuc.serverjva.domain.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Dữ liệu phép")
@TableName("PER_HOLIDAYAPPLY")
public class HrPersonHolidayApply {

    @TableId(value = "PER_HOLIDAYAPPLYOID")
    @ApiModelProperty(value = "Mã khóa chính")
    private String perHolidayOid;

    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value = "PER_ID")
    private String perId;

    @ApiModelProperty(value = "Mã phép")
    @TableField(value = "PHT_ID")
    private String phtId;

    @ApiModelProperty(value = "Từ ngày")
    @TableField(value = "HA_SDATE")
    private String haSdate;

    @ApiModelProperty(value = "Đến ngày")
    @TableField(value = "HA_EDATE")
    private String haEdate;

    @ApiModelProperty(value = "Số ngày nghỉ")
    @TableField(value = "HA_DAYS")
    private String haDays;

    @ApiModelProperty(value = "")
    @TableField(value = "APP_DATE")
    private String appDate;

    @ApiModelProperty(value = "Số ngày nghỉ")
    @TableField(value = "HA_REMARK")
    private String haRemark;

}
