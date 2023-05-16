package minhphuc.serverjva.model.response;

import lombok.Data;

@Data
public class TimeTracking {
    private String Time1;
    private String Time2;
    private String Time3;
    private String Time4;
    private Float workHours;
    private Integer overTime;
    private String workTime;
    private String breakTime;
    private Integer Offset;
    private Boolean status =true;

}
