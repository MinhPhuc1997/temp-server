package minhphuc.serverjva.controller.hr;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.HrTimeRecorder;
import minhphuc.serverjva.model.response.OffsetArray;
import minhphuc.serverjva.service.hr.HrTimeRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "1.Dữ liệu bù thẻ")
@RestController()
@RequestMapping(value = "/api/hrTimeRecorder")
public class HrTimeRecorderController {

    @Autowired
    private HrTimeRecorderService hrTimeRecorderService;

    @ApiOperation("API đăng nhập nếu thành công trả về token")
    @GetMapping("/byPerson")
    public List<OffsetArray> getHrTimeRecorderList(String date, String personNo) {
        return hrTimeRecorderService.getHrTimeRecorderList(date,personNo);
    }
}
