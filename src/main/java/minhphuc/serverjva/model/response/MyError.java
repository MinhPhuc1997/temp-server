package minhphuc.serverjva.model.response;

import lombok.Data;

@Data
public class MyError {
    private Integer code;

    private String msg;

    private String params;

}
