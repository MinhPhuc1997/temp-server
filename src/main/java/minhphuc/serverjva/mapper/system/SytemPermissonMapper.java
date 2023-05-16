package minhphuc.serverjva.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import minhphuc.serverjva.domain.system.SystemPermssion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SytemPermissonMapper extends BaseMapper<SystemPermssion> {

    @Select("SELECT perm from sys_permission a , sys_menu b WHERE a.menu_id = b.menu_id and a.user_id =#{userid}")
    List<String> getPermissonByUser(@Param("userid") String userid);
}
