package minhphuc.serverjva.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import minhphuc.serverjva.domain.system.SystemDepartment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemDepartmentMapper extends BaseMapper<SystemDepartment> {

    @Select("SELECT UCML_OrganizeOID AS organizeId,OrgNO,OrgName,ParentOID,hidden from UCML_Organize WHERE ParentOID ='000204C6-0000-0000-0000-0000FFEB38B0'")
    List<SystemDepartment> getOrgannize();

    @Select("with a as(\n" +
            "SELECT UCML_OrganizeOID AS organizeId,OrgNO,OrgName,ParentOID,hidden from UCML_Organize\n" +
            "WHERE ParentOID ='000204C6-0000-0000-0000-0000FFEB38B0'\n" +
            ")\n" +
            "SELECT UCML_OrganizeOID AS organizeId,OrgNO,OrgName,ParentOID,hidden from UCML_Organize WHERE ParentOID IN ( SELECT organizeId from a)")
    List<SystemDepartment> getDepartment();


}
