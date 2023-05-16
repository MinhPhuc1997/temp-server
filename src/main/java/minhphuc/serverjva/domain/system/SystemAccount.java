package minhphuc.serverjva.domain.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(description = "Tài khoản quản lý")
@TableName("sys_account")
public class SystemAccount {

    @TableId
    @ApiModelProperty(value = "Mã khóa chính")
    private String accountId;

    @ApiModelProperty(value = "Tài khoản đăng nhập")
    private String username;

    @ApiModelProperty(value = "Mật khẩu")
    private String password;

    @ApiModelProperty(value = "Họ và tên người dùng")
    private String userInfo;

    @ApiModelProperty(value = "Hình đại diện")
    private String img;

    @ApiModelProperty(value = "Trạng thái tài khoản")
    private Integer status;

    @ApiModelProperty(value = "Địa chỉ IP")
    private String ipAddress;

    @ApiModelProperty(value = "Cố định với ip")
    private Integer useIpRequest;

    @ApiModelProperty(value = "Địa chỉ MAC")
    private String macAddress;

    @ApiModelProperty(value = "Cố định với mac")
    private Integer useMacRequest;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Lần đổi mật khẩu gần nhất")
    private Date lastChangePw;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Lần đổi mật khẩu gần nhất")
    private Date lastTimeLogin;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Thời gian tạo tài khoản")
    private Date createTime;

    @ApiModelProperty(value = "Người tạo tài khoản")
    private String creator;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Thời gian cập nhật")
    private Date updateTime;

    @ApiModelProperty(value = "Người cập nhật")
    private String updator;

}
