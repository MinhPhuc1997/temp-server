package minhphuc.serverjva.service.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.domain.system.SystemDepartment;
import minhphuc.serverjva.mapper.system.SystemDepartmentMapper;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SytemDepartmentService {

    @Autowired
    SystemDepartmentMapper systemDepartmentMapper;

    public List<SystemDepartment> getSystemDepartmentAll(){
        return systemDepartmentMapper.getDepartment();
    }

    public List<SystemDepartment> getSystemOrannizeAll(){
        List<SystemDepartment> systemDepartments = systemDepartmentMapper.getOrgannize();
        return systemDepartments;
    }

    public List<SystemDepartment> getSystemDepartmentList(SystemDepartment systemDepartment){
        return systemDepartmentMapper.selectList(new QueryWrapper<>(systemDepartment));
    }

//    public List<SystemDepartment> getSystemDepartmentbyParent(String parent){
//
//        List<SystemDepartment> systemDepartments = systemDepartmentMapper.selectList(new QueryWrapper<>(systemDepartment));
//        return systemDepartments;
//    }

    public IPage<SystemDepartment> getSystemDepartmentByPage (PageUtil pageUtil,SystemDepartment systemDepartment){
        return systemDepartmentMapper.selectPage(new Page<SystemDepartment>(pageUtil.getPage(), pageUtil.getRows()), new QueryWrapper<>(systemDepartment));
    }
}
