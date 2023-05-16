package minhphuc.serverjva.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minhphuc.serverjva.domain.system.SystemAccount;
import minhphuc.serverjva.model.request.LoginForm;
import minhphuc.serverjva.service.system.SystemAccountService;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "1.Tài khoản đăng nhập")
@RestController()
@RequestMapping(value = "/api/systemAccount")
public class SystemAccountController {

    @Autowired
    private SystemAccountService systemAccountService;

    @ApiOperation("API đăng nhập nếu thành công trả về token")
    @PostMapping()
    public MessageResult loginSystemAccount(@RequestBody LoginForm loginForm) {
        return systemAccountService.loginSystemAccount(loginForm);
    }


//    @ApiOperation("Thêm dữ liệu mới phản hồi id")
//    @PostMapping()
//    public MessageResult saveEntity(SystemAccount systemAccount) {
//        return systemAccountService.saveEntity(systemAccount);
//    }
//
//    @ApiOperation("Xóa dữ liệu dựa vào id")
//    @DeleteMapping()
//    public MessageResult removeEntity(SystemAccount systemAccount) {
//        return systemAccountService.removeEntity(systemAccount);
//    }
//
//    @ApiOperation("Thêm dữ liệu mới phản hồi id")
//    @PutMapping()
//    public MessageResult updateEntity(SystemAccount systemAccount) {
//        return systemAccountService.updateEntity(systemAccount);
//    }
//
//    @ApiOperation("Tra cứu toàn bộ dữ liệu")
//    @GetMapping()
//    public List<SystemAccount> getEntity(SystemAccount systemAccount) {
//        return systemAccountService.getEntityList(systemAccount);
//    }
//
//    @ApiOperation("Tra cứu theo trang")
//    @GetMapping("/page")
//    public IPage<SystemAccount> getEntityListByPage(PageUtil pageUtil, SystemAccount systemAccount) {
//        return systemAccountService.getEntityListByPage(pageUtil, systemAccount);
  //  }

}
