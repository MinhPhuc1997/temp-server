package minhphuc.serverjva.model.response;

import lombok.Data;
import minhphuc.serverjva.domain.system.SystemPermssion;

import java.util.List;

@Data
public class LoginResponse {

    private boolean loginResult=true;

    private List<String> perm;

    private String token;

    private String userInfo;

    private String img;

}
