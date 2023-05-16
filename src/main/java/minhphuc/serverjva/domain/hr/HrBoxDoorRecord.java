package minhphuc.serverjva.domain.hr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
@ApiModel(description = "Thông tin quẹt thẻ từ máy chấm công")
@TableName("boxdoor_door_record")
public class HrBoxDoorRecord {

    @TableId(value="RecordID")
    @ApiModelProperty(value = "Mã nhân viên")
    private String recordID;

    @ApiModelProperty(value = "Mã nhân viên")
    @TableField(value="PersonNO")
    private String personNo;

    @ApiModelProperty(value = "Tên nhân viên")
    @TableField(value="PersonName")
    private String personName;

    @ApiModelProperty(value = "Mã code sự kiện ")
    @TableField(value="CredentialType")
    private String credentialType;

    @ApiModelProperty(value = "Tên sự kiện ")
    @TableField(value="CredentialName")
    private String credentialName;

    @ApiModelProperty(value = "Mã thiết bị")
    @TableField(value="DeviceID")
    private String deviceID;

    @ApiModelProperty(value = "Tên thiết bị")
    @TableField(value="DeviceName")
    private String deviceName;

    @ApiModelProperty(value = "Mã cửa")
    @TableField(value="DoorId")
    private String doorId;

    @ApiModelProperty(value = "Tên cửa")
    @TableField(value="doorName")
    private String doorName;

    @ApiModelProperty(value = "Mã hình ảnh nhân viên")
    @TableField(value="CardNum")
    private String cardNum;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Thời gian quẹt thẻ")
    @TableField(value="ActionTime")
    private Date actionTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "Thời gian hệ thống nhân dữ liệu")
    @TableField(value="InTime")
    private Date inTime;

    @ApiModelProperty(value = "source hình quẹt thẻ")
    @TableField(value="PictureFile")
    private String pictureFile;

    @ApiModelProperty(value = "Tra cứu theo ngày")
    @TableField(exist = false)
    private String Date;

}
