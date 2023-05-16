package minhphuc.serverjva.service.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.domain.hr.HrPerson;
import minhphuc.serverjva.mapper.hr.HrPersonMapper;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrPersonService {

    @Autowired
    HrPersonMapper hrPersonMapper;

    public List<HrPerson> getHrPersonList (HrPerson hrPerson){
        return hrPersonMapper.selectList(new QueryWrapper<>(hrPerson));
    }

    public IPage<HrPerson> getHrPersonListPage (PageUtil pageUtil, HrPerson hrPerson){
        return hrPersonMapper.selectPage(new Page<HrPerson>(pageUtil.getPage(),pageUtil.getRows()),new QueryWrapper<>(hrPerson));
    }
}
