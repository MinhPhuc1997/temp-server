package minhphuc.serverjva.config;

import minhphuc.serverjva.model.response.MyError;
import minhphuc.serverjva.utils.MessageResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MyErrorConfig implements ErrorController {


    @RequestMapping("/error")
    public MessageResult handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        MyError myError = new MyError();
        myError.setCode(statusCode);
        myError.setParams(request.getParameterMap().toString());
        switch (statusCode) {
            case 400:
                myError.setMsg("Sai kiểu dữ liệu truyền vào");
                break;
            case 404:
                myError.setMsg("Không tìm thấy API");
                break;
            case 405:
                myError.setMsg("Vui kiểm tra request method");
                break;
            case 500:
                myError.setMsg("Máy chủ bất thường");
                break;
            default:
                myError.setMsg("Lỗi khác");
                break;
        }
        return MessageResult.handleError(myError);
    }

}
