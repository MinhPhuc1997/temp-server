package minhphuc.serverjva.controller.hr;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.HrPerson;
import minhphuc.serverjva.service.hr.HrPersonService;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "2.Danh sách nhân viên")
@RestController()
@RequestMapping(value = "/api/hrPerson")
public class HrPersonController {

    @Autowired
    private HrPersonService hrPersonService;

    @ApiOperation("Tra cuu danh sach nhan vien")
    @GetMapping()
    public List<HrPerson> getHrPersonList(HrPerson hrPerson) {
        return hrPersonService.getHrPersonList(hrPerson);
    }

    @ApiOperation("Tra cuu danh sach nhan vien")
    @GetMapping("/page")
    public IPage<HrPerson> getHrPersonList(PageUtil pageUtil,HrPerson hrPerson) {
        return hrPersonService.getHrPersonListPage(pageUtil,hrPerson);
    }

}
