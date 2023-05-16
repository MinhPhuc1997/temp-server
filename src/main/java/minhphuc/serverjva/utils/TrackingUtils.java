package minhphuc.serverjva.utils;

import minhphuc.serverjva.domain.hr.HrBoxDoorRecord;
import minhphuc.serverjva.domain.hr.ViewPersonShift;
import minhphuc.serverjva.model.orther.PMType;
import minhphuc.serverjva.model.response.TimeTracking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class TrackingUtils {
    public static TimeTracking getTimeKeeping(List<HrBoxDoorRecord> hrBoxDoorRecords, ViewPersonShift personShift) {

        TimeTracking timeTracking = new TimeTracking();
        String dateQuery = personShift.getTrackingDate().substring(0, 10);
        String startwork = dateQuery + " " + personShift.getPsWorkHour1().substring(0, 8);
        String endwork = dateQuery + " " + personShift.getPsOffwork2().substring(0, 8);

        String endWork3start = dateQuery + " " + personShift.getPsOffwork3().substring(0, 8);
        String endWork3end = Tools.PlusMinusTime(endWork3start, PMType.PLUS, personShift.getPsMinuuesC3());

        String startTime1 = Tools.PlusMinusTime(startwork, PMType.MINUS, personShift.getPsMinuuesA1());
        String EndTime2 = Tools.PlusMinusTime(dateQuery + " " + personShift.getPsOffwork2().substring(0, 8),
                PMType.PLUS, personShift.getPsMinuuesC2());

        String startwork2End = dateQuery + " " + personShift.getPsWorkHour2().substring(0, 8);
        String startwork2Start = Tools.PlusMinusTime(startwork2End, PMType.MINUS, personShift.getPsMinuuesA2());

        String offwork1Start = dateQuery + " " + personShift.getPsOffwork1().substring(0, 8);

        timeTracking.setTime1(StartOrEndTime(hrBoxDoorRecords, startTime1, startwork, false));
        // Kiểm tra nếu là ca hành chính lấy dữ liệu từ work 2 nếu ko phải thì 3
        if (personShift.getPsInc()==1){
            timeTracking.setTime4(StartOrEndTime(hrBoxDoorRecords, endwork, EndTime2, true));

        }else{
            timeTracking.setTime4(StartOrEndTime(hrBoxDoorRecords, endWork3start, endWork3end, true));
        }
        // Kiểm tra có chia buổi ăn k nếu có thì tách dựa va2otho72i gian rest

        if (personShift.getBreakSplit()==1){
          List<String>  breakTimes= getTimeBreak(hrBoxDoorRecords,offwork1Start,personShift.getPsRest(),15);
            timeTracking.setTime2(breakTimes.get(0));
            timeTracking.setTime3(breakTimes.get(1));
        }else{
            String offworkEnd = Tools.PlusMinusTime(offwork1Start, PMType.PLUS, personShift.getPsMinuuesC1());
            timeTracking.setTime2(StartOrEndTime(hrBoxDoorRecords, offwork1Start, offworkEnd, false));
            timeTracking.setTime3(StartOrEndTime(hrBoxDoorRecords, startwork2Start, startwork2End, true));
        }

        timeTracking.setOffset(personShift.getSwipeId()!=null?1:0);

        timeTracking.setStatus(true);
        timeTracking.setWorkTime(startwork.substring(11, 19) + "-" +
                ((personShift.getPsInc()==1)?endwork.substring(11, 19):endWork3start.substring(11,19)));
        String breakTime1  =offwork1Start.substring(11, 19) + "-" + startwork2End.substring(11, 19);
        timeTracking.setBreakTime(breakTime1);



        if (timeTracking.getTime1()=="") {
            if(personShift.getSwipeTime1()!=null) {
                timeTracking.setTime1((personShift.getSwipeTime1()).substring(11, 19));
            }
            timeTracking.setStatus(timeTracking.getTime1()==null);
        }
        if (timeTracking.getTime2()=="") {
            if(personShift.getSwipeTime2()!=null){
                timeTracking.setTime2((personShift.getSwipeTime2().substring(11,19)));
            }
            timeTracking.setStatus(timeTracking.getTime2()==null);
        }
        if (timeTracking.getTime3()=="") {
           if(personShift.getSwipeTime3()!=null){
               timeTracking.setTime3((personShift.getSwipeTime3().substring(11,19)));
            }
            timeTracking.setStatus(timeTracking.getTime3()==null);
        }
        if (timeTracking.getTime4()=="") {
            if(personShift.getSwipeTime4()!=null){
                timeTracking.setTime4((personShift.getSwipeTime4()).substring(11,19));
            }
            timeTracking.setStatus(timeTracking.getTime4()==null);
        }

        // bù thẻ trường hợp giữa ca
        if(personShift.getPsInc()!=1){
            if(timeTracking.getTime2()==""|| timeTracking.getTime3()==""){
                String temp = timeTracking.getTime2() + timeTracking.getTime3();
                if(personShift.getSwipeTime2()!=null){
                    timeTracking.setTime2(personShift.getSwipeTime2().substring(11,19));
                    timeTracking.setTime3(temp);
                }
                if(personShift.getSwipeTime3()!=null){
                    timeTracking.setTime3(personShift.getSwipeTime3().substring(11,19));
                    timeTracking.setTime2(temp);
                }
            }
        }

        timeTracking.setWorkHours((float) ((timeTracking.getStatus()) ? personShift.getWorkHours() : 0));
        return timeTracking;
    }

    public static String StartOrEndTime(List<HrBoxDoorRecord> hrBoxDoorRecords, String timeStart, String timeEnd, Boolean top) {

        List<String> result = new ArrayList<>();
        for (HrBoxDoorRecord hrBoxDoorRecord : hrBoxDoorRecords) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String utcTime = dateFormat.format(hrBoxDoorRecord.getActionTime());
            if (checkTimeInDistance(utcTime, timeStart, timeEnd)) {
                result.add(utcTime.substring(11, 19));
            }
        }
        if (result.size() == 1) {
            return result.get(0);
        }
        if (result.size() > 1) {
            return result.get((top) ? result.size() - 1 : 0);
        }
        return "";
    }

    public static List<String> getTimeBreak(List<HrBoxDoorRecord> hrBoxDoorRecords,String startTime,Integer rest,Integer distance){
        String offwork1End1 = Tools.PlusMinusTime(startTime, PMType.PLUS, rest);
        String offwork1End2 = Tools.PlusMinusTime(offwork1End1, PMType.PLUS, rest);
        List<String> timeList1 = new ArrayList<>();
        List<String> timeList2 = new ArrayList<>();
        for (HrBoxDoorRecord record:hrBoxDoorRecords) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String utcTime = dateFormat.format(record.getActionTime());
            if (checkTimeInDistance(utcTime, startTime, offwork1End1)) {
                if(checkScanPushToData(timeList1,utcTime.substring(11, 19),distance)){
                    timeList1.add(utcTime.substring(11, 19));
                }

            }
            if (checkTimeInDistance(utcTime, offwork1End1, offwork1End2)) {
                if(checkScanPushToData(timeList2,utcTime.substring(11, 19),distance)){
                    timeList2.add(utcTime.substring(11, 19));
                }
            }
        };
        if (timeList1.size()>1){
            return  timeList1;
        }
        if (timeList2.size()>1){
            return  timeList2;
        }
        if (timeList1.size()==1){
            timeList1.add("");
            return timeList1;
        }
        if (timeList2.size()==1){
            timeList2.add("");
            return timeList2;
        }
        timeList1.add("");
        timeList1.add("");
        return timeList1;
    }

    public static Boolean checkScanPushToData(List<String> time,String newTime, Integer dis){
        if (time.size()==0){
            return true;
        }
        String lastItem = time.get(time.size()-1);
        if(Tools.convertMinuToSec(newTime)-Tools.convertMinuToSec(lastItem)>=dis*60){
            return true;
        }
        return false;

    }

    public static Boolean checkTimeInDistance(String timeCheck, String timeBegin, String timeEnd) {
        if (Tools.convertDateTimeToNumber(timeCheck) >= Tools.convertDateTimeToNumber(timeBegin)
                && Tools.convertDateTimeToNumber(timeCheck) <= Tools.convertDateTimeToNumber(timeEnd)) {
            return true;
        }
        return false;
    }

}
