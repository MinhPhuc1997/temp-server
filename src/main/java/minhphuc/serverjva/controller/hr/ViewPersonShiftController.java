package minhphuc.serverjva.controller.hr;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.hr.ViewPersonShift;
import minhphuc.serverjva.service.hr.ViewPersonShiftService;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "ViewPersonShift")
@RestController()
@RequestMapping(value = "/api/viewPersonShift")
public class ViewPersonShiftController {

    @Autowired
    ViewPersonShiftService viewPersonShiftService;

    @ApiOperation("Tra cứu toàn bộ dữ liệu")
    @GetMapping()
    public IPage<ViewPersonShift> getHrWorkShiftList(PageUtil pageUtil,ViewPersonShift hrWorkShift) {
        return viewPersonShiftService.getViewPersonShiftList(pageUtil,hrWorkShift);
    }

}
