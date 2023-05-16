package minhphuc.serverjva.utils;

import minhphuc.serverjva.domain.system.SystemCode;

import java.util.List;
import java.util.UUID;

public class StringUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    public static String GetValue(List<SystemCode> systemCodes, String key, String value, String Lanague){
        for (int i = 0; i < systemCodes.size(); i++) {
            if (systemCodes.get(i).getCodeValue().equals(value) && systemCodes.get(i).getCodeKey().equals(key)){
                if (Lanague==null ){
                    return systemCodes.get(i).getCodeNameVi();
                }
                if (Lanague.equals("cn")){
                    return systemCodes.get(i).getCodeNameCn();
                }
                if (Lanague.equals("en")){
                    return systemCodes.get(i).getCodeNameEn();
                }
                return systemCodes.get(i).getCodeNameVi();
            }
        }
        return "";
    }
}
