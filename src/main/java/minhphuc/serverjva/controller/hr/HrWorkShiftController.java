package minhphuc.serverjva.controller.hr;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.HrWorkShift;
import minhphuc.serverjva.service.hr.HrWorkShiftService;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "4.Danh sách ca làm")
@RestController()
@RequestMapping(value = "/api/hrWorkShift")
public class HrWorkShiftController {

    @Autowired
    private HrWorkShiftService hrWorkShiftService;

    @ApiOperation("Thêm dữ liệu mới phản hồi id")
    @PostMapping()
    public MessageResult saveHrWorkShift(HrWorkShift hrWorkShift) {
        return hrWorkShiftService.saveHrWorkShift(hrWorkShift);
    }

    @ApiOperation("Xóa dữ liệu dựa vào id")
    @DeleteMapping()
    public MessageResult removeHrWorkShift(HrWorkShift hrWorkShift) {
        return hrWorkShiftService.removeHrWorkShift(hrWorkShift);
    }

    @ApiOperation("Thêm dữ liệu mới phản hồi id")
    @PutMapping()
    public MessageResult updateHrWorkShift(HrWorkShift hrWorkShift) {
        return hrWorkShiftService.updateHrWorkShift(hrWorkShift);
    }

    @ApiOperation("Tra cứu toàn bộ dữ liệu")
    @GetMapping()
    public List<HrWorkShift> getHrWorkShiftList(HrWorkShift hrWorkShift) {
        return hrWorkShiftService.getHrWorkShiftList(hrWorkShift);
    }

    @ApiOperation("Tra cứu theo trang")
    @GetMapping("/page")
    public IPage<HrWorkShift> getHrWorkShiftListByPage(PageUtil pageUtil, HrWorkShift hrWorkShift) {
        return hrWorkShiftService.getHrWorkShiftListByPage(pageUtil, hrWorkShift);
    }
}
