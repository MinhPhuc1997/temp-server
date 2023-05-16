package minhphuc.serverjva.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@ApiModel(description = "Tài khoản quản lý")
@TableName("UCML_Organize")
public class SystemDepartment {

    @TableField(value="UCML_OrganizeOID")
    @ApiModelProperty(value = "Mã khóa chính")
    private String organizeId;

    @ApiModelProperty(value = "Mã bộ phận")
    @TableField(value = "OrgNO")
    private String orgNO;

    @ApiModelProperty(value = "Tên bộ phận")
    @TableField(value = "OrgName")
    private String OrgName;

    @ApiModelProperty(value = "Id gốc")
    @TableField(value = "ParentOID")
    private String ParentOID;

    @ApiModelProperty(value = "Hiển thị tra cứu")
    @TableField(value = "hidden")
    private Integer hidden;

    @ApiModelProperty(value = "Hiển thị tra cứu")
    @TableField(exist = false)
    private List<SystemDepartment> children;

}
