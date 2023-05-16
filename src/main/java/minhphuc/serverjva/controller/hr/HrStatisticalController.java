package minhphuc.serverjva.controller.hr;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.HrTimeRecorder;
import minhphuc.serverjva.service.hr.HrStatisticalService;
import minhphuc.serverjva.utils.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Thống kê dữ liệu")
@RestController()
@RequestMapping(value = "/api/hrStatistical")
public class HrStatisticalController {

    @Autowired
    HrStatisticalService hrStatisticalService;

    @ApiOperation("API đăng nhập nếu thành công trả về token")
    @GetMapping("")
    public MessageResult getHrTimeRecorderList(Integer year, Integer month) {
        return hrStatisticalService.getStatistical(year,month);
    }
}
