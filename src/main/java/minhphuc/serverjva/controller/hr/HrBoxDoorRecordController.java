package minhphuc.serverjva.controller.hr;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.HrBoxDoorRecord;
import minhphuc.serverjva.service.hr.HrBoxDoorRecordService;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "3.Dữ liệu chấm công của máy quẹt gương mặt")
@RestController()
@RequestMapping(value = "/api/hrBoxDoorRecord")
public class HrBoxDoorRecordController {

    @Autowired
    private HrBoxDoorRecordService hrBoxDoorRecordService;

    @ApiOperation("Thêm dữ liệu mới phản hồi id")
    @PostMapping()
    public MessageResult saveEntity(HrBoxDoorRecord hrBoxDoorRecord) {
        return hrBoxDoorRecordService.saveEntity(hrBoxDoorRecord);
    }

    @ApiOperation("Xóa dữ liệu dựa vào id")
    @DeleteMapping()
    public MessageResult removeEntity(HrBoxDoorRecord hrBoxDoorRecord) {
        return hrBoxDoorRecordService.removeEntity(hrBoxDoorRecord);
    }

    @ApiOperation("Thêm dữ liệu mới phản hồi id")
    @PutMapping()
    public MessageResult updateEntity(HrBoxDoorRecord hrBoxDoorRecord) {
        return hrBoxDoorRecordService.updateEntity(hrBoxDoorRecord);
    }

    @ApiOperation("Tra cứu toàn bộ dữ liệu")
    @GetMapping()
    public List<HrBoxDoorRecord> getEntity(HrBoxDoorRecord hrBoxDoorRecord) {
        return hrBoxDoorRecordService.getEntityList(hrBoxDoorRecord);
    }

    @ApiOperation("Tra cứu chi tiết quẹt thẻ của từng người")
    @GetMapping("/detail")
    public List<HrBoxDoorRecord> getEntityListByDetail(String personNo,String date,String shiftId) {
        return hrBoxDoorRecordService.getEntityListByDetail(personNo,date,shiftId);
    }

    @ApiOperation("Tra cứu theo trang")
    @GetMapping("/page")
    public IPage<HrBoxDoorRecord> getEntityListByPage(PageUtil pageUtil, HrBoxDoorRecord hrBoxDoorRecord) {
        return hrBoxDoorRecordService.getEntityListByPage(pageUtil, hrBoxDoorRecord);
    }
}
