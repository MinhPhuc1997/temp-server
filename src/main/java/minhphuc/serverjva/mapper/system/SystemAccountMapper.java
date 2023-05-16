package minhphuc.serverjva.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import minhphuc.serverjva.domain.system.SystemAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface SystemAccountMapper extends BaseMapper<SystemAccount> {

    @Select("SELECT TOP 1 * FROM sys_account WHERE username=#{username} and password=#{password}")
    SystemAccount getUsersByUsername(@Param("username")String username,@Param("password") String password);

}
