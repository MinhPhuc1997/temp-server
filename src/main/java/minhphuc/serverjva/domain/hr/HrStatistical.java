package minhphuc.serverjva.domain.hr;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import minhphuc.serverjva.model.response.MonthTrackingData;
import minhphuc.serverjva.model.response.StatisticalRowDetail;
import minhphuc.serverjva.service.hr.HrOrgannizeSummary;

import java.util.List;

@Data
public class HrStatistical {

    @ApiModelProperty(value = "Thống kê tổng tháng")
    private MonthTrackingData monthStatis;

    @ApiModelProperty(value = "Dữ liệu bù thẻ theo tuần")
    private List<StatisticalRowDetail> offsetDetail;

    @ApiModelProperty(value = "Dữ liệu nghỉ phép theo tuần")
    private List<StatisticalRowDetail> furloughDetail;

    @ApiModelProperty(value = "Chi tiết dựa theo bộ phận")
    private List<HrOrgannizeSummary> orgDetail;

}
