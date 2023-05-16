package minhphuc.serverjva.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.system.SystemCode;
import minhphuc.serverjva.service.system.SystemCodeService;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Mã code chung")
@RestController()
@RequestMapping(value = "/api/systemCode")
public class SystemCodeController {

    @Autowired
    SystemCodeService systemCodeService;

    @ApiOperation("Thêm dữ liệu mới phản hồi id")
    @PostMapping()
    public MessageResult saveEntity(SystemCode systemCode) {
        return systemCodeService.saveSystemCode(systemCode);
    }

    @ApiOperation("Xóa dữ liệu dựa vào id")
    @DeleteMapping()
    public MessageResult removeEntity(SystemCode systemCode) {
        return systemCodeService.removeSystemCode(systemCode);
    }

    @ApiOperation("Thêm dữ liệu mới phản hồi id")
    @PutMapping()
    public MessageResult updateEntity(SystemCode systemCode) {
        return systemCodeService.updateSystemCode(systemCode);
    }

    @ApiOperation("Tra cứu toàn bộ dữ liệu")
    @GetMapping()
    public List<SystemCode> getEntity(SystemCode systemCode) {
        return systemCodeService.getSystemCodeList(systemCode);
    }

    @ApiOperation("Tra cứu theo trang")
    @GetMapping("/page")
    public IPage<SystemCode> getEntityListByPage(PageUtil pageUtil, SystemCode systemCode) {
        return systemCodeService.getSystemCodeListByPage(pageUtil, systemCode);
      }
}
