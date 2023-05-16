package minhphuc.serverjva.domain.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Dữ liệu nhân vien")
@TableName("PER_PERSON")
public class HrPerson {

    @TableId(value = "PER_PERSONOID")
    @ApiModelProperty(value = "Mã khóa chính")
    private String PER_PERSONOID;

    @ApiModelProperty(value = "")
    @TableField(value = "PER_ID")
    private String perId;

    @ApiModelProperty(value = "")
    @TableField(value = "PER_NAME")
    private String perName;

    @ApiModelProperty(value = "")
    @TableField(value = "PER_ENAME")
    private String perEName;

    @ApiModelProperty(value = "")
    @TableField(value = "SEX_ID")
    private String sexId;

    @ApiModelProperty(value = "")
    @TableField(value = "PostID")
    private String postId;

    @ApiModelProperty(value = "")
    @TableField(value = "PER_STATUS")
    private String perStatus;

    @ApiModelProperty(value = "")
    @TableField(value = "POLITICS")
    private String politics;

    @ApiModelProperty(value = "")
    @TableField(value = "OrgNO")
    private String orgNo;

    @ApiModelProperty(value = "")
    @TableField(value = "OrgName")
    private String orgName;

    @ApiModelProperty(value = "")
    @TableField(value = "UCML_Organize_FK")
    private String ucmlOrganizeFk;

}
