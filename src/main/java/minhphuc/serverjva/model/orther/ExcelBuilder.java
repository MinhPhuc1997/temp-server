package minhphuc.serverjva.model.orther;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExcelBuilder {

    private BaseMapper baseMapper;

    private LambdaQueryWrapper lambdaQueryWrapper;

    private Integer pageNo = 1;

    private Integer pageSize = 1000;

    private Class<?> sourceClass;

    private String fileName;

    private String sheetName;
}
