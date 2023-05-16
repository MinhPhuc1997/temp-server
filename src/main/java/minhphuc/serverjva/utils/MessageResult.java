package minhphuc.serverjva.utils;
import lombok.Data;

@Data
public class MessageResult {

    private int code;
    private Object data;
    private String msg;

    public static MessageResult result(int code, String msg, Object data) {
        MessageResult result = new MessageResult();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
    public static MessageResult error(String msg) {
        MessageResult result = new MessageResult();
        result.setCode(-1);
        result.setMsg(msg);
        return result;
    }

    public static MessageResult handleError(Object data) {
        MessageResult result = new MessageResult();
        result.setCode(-1);
        result.setData(data);
        return result;
    }

    public static MessageResult success(Object data) {
        MessageResult result = new MessageResult();
        result.setMsg("Thao tác thành công!");
        result.setCode(0);
        result.setData(data);
        return result;
    }

}
