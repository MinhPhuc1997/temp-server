package minhphuc.serverjva.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OffsetArray {

    @ApiModelProperty(value = "STT")
    private Integer index;

    @ApiModelProperty(value = "Ngày bù thẻ")
    private String date;

    @ApiModelProperty(value = "Thời gian bù thẻ")
    private String time;

    @ApiModelProperty(value = "Lý do")
    private String reason;

}
