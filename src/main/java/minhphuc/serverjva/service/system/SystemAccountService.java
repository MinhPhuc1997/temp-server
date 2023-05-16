package minhphuc.serverjva.service.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.model.request.LoginForm;
import minhphuc.serverjva.model.response.LoginResponse;
import minhphuc.serverjva.domain.system.SystemAccount;
import minhphuc.serverjva.mapper.system.SystemAccountMapper;
import minhphuc.serverjva.mapper.system.SytemPermissonMapper;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import minhphuc.serverjva.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class SystemAccountService {

    @Autowired
    SystemAccountMapper systemAccountMapper;

    @Autowired
    SytemPermissonMapper sytemPermissonMapper;

    public MessageResult saveEntity(SystemAccount systemAccount){
        String uuid = StringUtils.getUUID();
        systemAccount.setAccountId(uuid);
        systemAccountMapper.insert(systemAccount);
        return MessageResult.success(uuid);
    }

    public MessageResult removeEntity(SystemAccount systemAccount){
        if ( systemAccount.getAccountId().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để xóa");
        }
        Integer result = systemAccountMapper.deleteById(systemAccount);
        return MessageResult.success(result);
    }

    public MessageResult updateEntity(SystemAccount systemAccount){
        if (systemAccount.getAccountId().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để cập nhật");
        }
        Integer result = systemAccountMapper.updateById(systemAccount);
        return MessageResult.success(result);
    }

    public List<SystemAccount> getEntityList(SystemAccount systemAccount){
        List<SystemAccount> systemAccounts = systemAccountMapper.selectList(new QueryWrapper<>(systemAccount));
        return systemAccounts;
    }

    public IPage<SystemAccount> getEntityListByPage(PageUtil pageUtil, SystemAccount systemAccount) {
        return systemAccountMapper.selectPage(new Page<SystemAccount>(pageUtil.getPage(), pageUtil.getRows()), new QueryWrapper<>(systemAccount));
    }

    public MessageResult loginSystemAccount(LoginForm loginForm){
        if (loginForm.getUsername()==null){
            return MessageResult.error("Vui lòng nhập tài khoản");
        }
        if (loginForm.getPassword()==null){
            return MessageResult.error("Vui lòng nhập mật khẩu");
        }
        SystemAccount systemAccounts = systemAccountMapper.getUsersByUsername(loginForm.getUsername(),loginForm.getPassword());
        if (systemAccounts==null){
            return MessageResult.error("Vui lòng kiểm tra lại tài khoản hoặc mật khẩu");
        }
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(systemAccounts.getAccountId());
        loginResponse.setUserInfo(systemAccounts.getUserInfo());
        loginResponse.setImg(systemAccounts.getImg());
        if (Objects.equals(systemAccounts.getUsername(), "admin")){
            loginResponse.setPerm(Collections.singletonList("*:*:*"));
            return MessageResult.success(loginResponse);
        }
        List<String> permssions = sytemPermissonMapper.getPermissonByUser(systemAccounts.getAccountId());
        loginResponse.setPerm(permssions);
        return MessageResult.success(loginResponse);
    }

}
