package minhphuc.serverjva.domain.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Tài khoản quản lý")
@TableName("sys_menu")
public class SystemMenu {
    @TableId
    @ApiModelProperty(value = "Mã menu")
    private String menuId;

    @ApiModelProperty(value = "Tên menu")
    private String menu_name;

    @ApiModelProperty(value = "mã quyền hạn")
    private String perm;

    @ApiModelProperty(value = "Trạng thái tắt")
    private String disabled;

    @ApiModelProperty(value = "icon menu")
    private String icon;

    @ApiModelProperty(value = "ghi chú")
    private String note;

    @ApiModelProperty(value = "Thể loại 1: menu 2: button 3: liên kết")
    private String type;

    @ApiModelProperty(value = "Sắp xếp theo thứ tự")
    private String sn;
}
