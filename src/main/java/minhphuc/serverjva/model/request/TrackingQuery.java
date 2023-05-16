package minhphuc.serverjva.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TrackingQuery {

    @ApiModelProperty(value = "Mã trung tâm")
    private String orgId;

    @ApiModelProperty(value = "Mã bộ phận")
    private String department;

    @ApiModelProperty(value = "Mã nhân viên")
    private String personNo;

    @ApiModelProperty(value = "Tên nhân viên")
    private String personName;

    @ApiModelProperty(value = "Quốc tịch")
    private String politics;

    @ApiModelProperty(value = "Thời gian bắt đầu")
    private String dateBegin;

    @ApiModelProperty(value = "Thời gian kết thúc")
    private String dateEnd;

    @ApiModelProperty(value = "Mã ca làm")
    private Integer shiftId;

    @ApiModelProperty(value = "bù thẻ : 1. Có 0. Không")
    private Integer offset;

    @ApiModelProperty(value = "Nghỉ phép : 1. Có 0. Không")
    private Integer furlough;

    @ApiModelProperty(value = "Trạng thái : 1. Bất thuong 0. Binh thuong")
    private Integer status;

}
