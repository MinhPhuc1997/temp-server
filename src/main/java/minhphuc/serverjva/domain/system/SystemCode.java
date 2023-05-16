package minhphuc.serverjva.domain.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Dữ liệu code chung")
@TableName("sys_code")
public class SystemCode {

    @TableId
    @ApiModelProperty(value = "Mã khóa chính")
    private String codeId;

    @ApiModelProperty(value = "Mã code")
    private String codeValue;

    @ApiModelProperty(value = "Tên tiếng việt")
    private String codeNameVi;

    @ApiModelProperty(value = "Tên tiếng trung")
    private String codeNameCn;

    @ApiModelProperty(value = "Tên tiếng tếng anh")
    private String codeNameEn;

    @ApiModelProperty(value = "sắp sếp")
    private String sn;

    @ApiModelProperty(value = "key code")
    private String codeKey;

    @ApiModelProperty(value = "Trạng thái xóa")
    private Integer delFlag;
}
