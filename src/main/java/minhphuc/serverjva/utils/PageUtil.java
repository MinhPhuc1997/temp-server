package minhphuc.serverjva.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Tham số phân trang")
public class PageUtil {

    @ApiModelProperty("Trang tra cứu")
    private int start;

    @ApiModelProperty("Số hàng dữ liệu")
    private int rows=20;

    @ApiModelProperty("Trang hiện tại")
    private int page;

    public int getPage() {
        if (start >0) {
            page = start;
        }
        return page;
    }
}
