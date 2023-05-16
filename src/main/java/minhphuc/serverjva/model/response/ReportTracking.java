package minhphuc.serverjva.model.response;

import lombok.Data;

@Data
public class ReportTracking {
    private Integer index;

    private String personNo;

    private String personName;

    private String trackingDate;

    private String dayOfWeek;

    private String orgName;

    private String shiftName;

    private String time1;

    private String time2;

    private String time3;

    private String time4;

    private String offset;

    private String fourghHours;

    private String fourghName;

    private Float workHours;

    private String overTime;

    private String status;

    private String note;
}
