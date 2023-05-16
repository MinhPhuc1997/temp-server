package minhphuc.serverjva.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.system.SystemDepartment;
import minhphuc.serverjva.service.system.SytemDepartmentService;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "2.Trung tâm, bộ phận")
@RestController()
@RequestMapping(value = "/api/systemDepartment")
public class SystemDepartmentController {

    @Autowired
    SytemDepartmentService sytemDepartmentService;

    @ApiOperation("Tra cứu danh sách bộ phận")
    @GetMapping()
    public List<SystemDepartment> getSystemDepartmentList(SystemDepartment systemDepartment) {
        return sytemDepartmentService.getSystemDepartmentList(systemDepartment);
    }

    @ApiOperation("Tra cứu danh sách bộ phận")
    @GetMapping("/dep")
    public List<SystemDepartment> getSystemDepartmentAll() {
        return sytemDepartmentService.getSystemDepartmentAll();
    }

    @ApiOperation("Tra cứu danh sách trung tâm")
    @GetMapping("/org")
    public List<SystemDepartment> getSystemOrannizeAll() {
        return sytemDepartmentService.getSystemOrannizeAll();
    }

    @ApiOperation("Tra cứu danh sách bộ phận phân trang")
    @GetMapping("/page")
    public IPage<SystemDepartment> getSystemDepartmentByPage(PageUtil pageUtil,SystemDepartment systemDepartment) {
        return sytemDepartmentService.getSystemDepartmentByPage(pageUtil,systemDepartment);
    }
}
