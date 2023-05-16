package minhphuc.serverjva.service.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import minhphuc.serverjva.domain.hr.ViewPersonShift;
import minhphuc.serverjva.mapper.hr.ViewPersonShiftMapper;
import minhphuc.serverjva.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewPersonShiftService {

    @Autowired
    ViewPersonShiftMapper viewPersonShiftMapper;

    public IPage<ViewPersonShift> getViewPersonShiftList(PageUtil pageUtil,ViewPersonShift viewPersonShift){
        IPage<ViewPersonShift> page = new Page<>(1, 10);
        return viewPersonShiftMapper.selectPage(page,null);
    }
}
