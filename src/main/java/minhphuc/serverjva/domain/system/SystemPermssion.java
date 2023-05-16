package minhphuc.serverjva.domain.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Tài khoản quản lý")
@TableName("sys_permission")
public class SystemPermssion {
    @TableId
    @ApiModelProperty(value = "Mã khóa chính")
    private String permId;

    @ApiModelProperty(value = "mã tài khoản")
    private String userId;

    @ApiModelProperty(value = "mã quyền hạn")
    private String menuId;
}
