package minhphuc.serverjva.service.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.domain.system.SystemCode;
import minhphuc.serverjva.mapper.system.SystemCodeMapper;
import minhphuc.serverjva.utils.MessageResult;
import minhphuc.serverjva.utils.PageUtil;
import minhphuc.serverjva.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemCodeService {

    @Autowired
    SystemCodeMapper systemCodeMapper;

    public MessageResult saveSystemCode(SystemCode systemCode){
        String uuid = StringUtils.getUUID();
        systemCode.setCodeId(uuid);
        systemCodeMapper.insert(systemCode);
        return MessageResult.success(uuid);
    }

    public MessageResult removeSystemCode(SystemCode systemCode){
        if ( systemCode.getCodeId().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để xóa");
        }
        Integer result = systemCodeMapper.deleteById(systemCode);
        return MessageResult.success(result);
    }

    public MessageResult updateSystemCode(SystemCode systemCode){
        if (systemCode.getCodeId().isEmpty()){
            return MessageResult.error("Vui lòng sử dụng id để cập nhật");
        }
        Integer result = systemCodeMapper.updateById(systemCode);
        return MessageResult.success(result);
    }

    public List<SystemCode> getSystemCodeList(SystemCode systemCode){
        return systemCodeMapper.selectList(new QueryWrapper<>(systemCode).ne("del_flag",1).orderByAsc("code_key","sn"));
    }

    public IPage<SystemCode> getSystemCodeListByPage(PageUtil pageUtil, SystemCode systemCode) {
        return systemCodeMapper.selectPage(new Page<SystemCode>(pageUtil.getPage(), pageUtil.getRows()), new QueryWrapper<>(systemCode));
    }

}
