package minhphuc.serverjva.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import minhphuc.serverjva.domain.hr.HrBoxDoorRecord;
import minhphuc.serverjva.domain.hr.HrTimeRecorder;
import minhphuc.serverjva.domain.hr.ViewPersonShift;
import minhphuc.serverjva.model.orther.PMType;
import minhphuc.serverjva.model.request.TrackingQuery;
import minhphuc.serverjva.model.response.OffsetArray;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Tools {

    public static String PlusMinusTime(String dateString, PMType pmType, Integer minutes) {
        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime newDateTime = (pmType == PMType.MINUS) ? dateTime.minusMinutes(minutes) : dateTime.plusMinutes(minutes);
        return newDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String DayOfWeek(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "0";
            case Calendar.MONDAY:
                return "1";
            case Calendar.TUESDAY:
                return "2";
            case Calendar.WEDNESDAY:
                return "3";
            case Calendar.THURSDAY:
                return "4";
            case Calendar.FRIDAY:
                return "5";
            case Calendar.SATURDAY:
                return "6";
            default:
                return "";
        }
    }

    public static <T> List<String> getListInObject(List<T> array,String name) throws NoSuchFieldException, IllegalAccessException {
        List<String> result = new ArrayList<>();
        for (T data: array ) {
            Field field = data.getClass().getDeclaredField(name);

            field.setAccessible(true);
            String value = field.get(data).toString();
            if (!result.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static Integer convertMinuToSec(String time){
        Integer hh = Integer.valueOf(time.substring(0,2));
        Integer mm = Integer.valueOf(time.substring(3,5));
        Integer ss = Integer.valueOf(time.substring(6,8));
        return hh*2600+mm*60+ss;
    }
    public static <T> List search(List<T> arrayList, String name, String valueFind) {
        List<T> result = new ArrayList<>();
        for (T item:arrayList ) {
            Field field = null;
            try {
                field = item.getClass().getDeclaredField(name);
                field.setAccessible(true);
                String value = field.get(item).toString();
                if(value.equals(valueFind)){
                    result.add(item);
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(dateString);
    }

    public static Long convertDateTimeToNumber (String date){
        String yy = date.substring(0,4);
        String MM =date.substring(5,7);
        String dd = date.substring(8,10);
        String hh = date.substring(11,13);
        String mm = date.substring(14,16);
        String ss = date.substring(17,19);
        return Long.valueOf(yy+MM+dd+hh+mm+ss);
    }

    public static QueryWrapper trackQueryWarapper(TrackingQuery trackingQuery){
        QueryWrapper queryWrapper = new QueryWrapper<ViewPersonShift>()
                .ge("PS_DATE", trackingQuery.getDateBegin() + " 00:00:00")
                .le("PS_DATE", trackingQuery.getDateEnd() + " 23:59:59");
        if (trackingQuery.getOrgId()!=null){
            queryWrapper.eq("organize_fk",trackingQuery.getOrgId());
        }
        if (trackingQuery.getDepartment()!=null){
            queryWrapper.eq("organize_fk",trackingQuery.getDepartment());
        }
        if (trackingQuery.getShiftId()!=null){
            queryWrapper.eq("PS_INC",trackingQuery.getShiftId());
        }
        if (trackingQuery.getPolitics()!=null){
            queryWrapper.eq("politics",trackingQuery.getPolitics());
        }
        if (trackingQuery.getPersonNo()!=null){
            queryWrapper.like("PER_ID",trackingQuery.getPersonNo());
        }
        if (trackingQuery.getPersonName()!=null){
            queryWrapper.like("PER_NAME",trackingQuery.getPersonName());
        }
        if (trackingQuery.getOffset()!=null){
            if(trackingQuery.getOffset() == 1){
                queryWrapper.isNotNull("swipe_id");
            }else{
                queryWrapper.isNull("swipe_id");
            }
        }
        return queryWrapper;
    }

    public static List<OffsetArray> convertOffsetObjectToArray(List<HrTimeRecorder> hrTimeRecorder){
        List<OffsetArray> offsetArrays = new ArrayList<>();
        if (hrTimeRecorder.size()==0){
            return offsetArrays;
        }
        if (hrTimeRecorder.get(0).getSwipeTime1()!=null){
            OffsetArray offsetArray = new OffsetArray();
            offsetArray.setDate(hrTimeRecorder.get(0).getSwipeDate1().substring(0,10));
            offsetArray.setTime(hrTimeRecorder.get(0).getSwipeTime1().substring(11,19));
            offsetArray.setReason(hrTimeRecorder.get(0).getReason());
            offsetArrays.add(offsetArray);
        }
        if (hrTimeRecorder.get(0).getSwipeTime2()!=null){
            OffsetArray offsetArray = new OffsetArray();
            offsetArray.setDate(hrTimeRecorder.get(0).getSwipeDate2().substring(0,10));
            offsetArray.setTime(hrTimeRecorder.get(0).getSwipeTime2().substring(11,19));
            offsetArray.setReason(hrTimeRecorder.get(0).getReason());
            offsetArrays.add(offsetArray);
        }
        if (hrTimeRecorder.get(0).getSwipeTime3()!=null){
            OffsetArray offsetArray = new OffsetArray();
            offsetArray.setDate(hrTimeRecorder.get(0).getSwipeDate3().substring(0,10));
            offsetArray.setTime(hrTimeRecorder.get(0).getSwipeTime3().substring(11,19));
            offsetArray.setReason(hrTimeRecorder.get(0).getReason());
            offsetArrays.add(offsetArray);
        }
        if (hrTimeRecorder.get(0).getSwipeTime4()!=null){
            OffsetArray offsetArray = new OffsetArray();
            offsetArray.setDate(hrTimeRecorder.get(0).getSwipeDate4().substring(0,10));
            offsetArray.setTime(hrTimeRecorder.get(0).getSwipeTime4().substring(11,19));
            offsetArray.setReason(hrTimeRecorder.get(0).getReason());
            offsetArrays.add(offsetArray);
        }
        AtomicInteger index = new AtomicInteger(1);
        List<OffsetArray> updatedOffsetArrays = offsetArrays.stream()
                .map(item -> {
                    item.setIndex(index.getAndIncrement());
                    return item;
                })
                .collect(Collectors.toList());
        return offsetArrays;

    }

    public static QueryWrapper boxDoorTimeQueryWrapper(String personNo,String date,String shift){
        QueryWrapper queryWrapper = new QueryWrapper<HrBoxDoorRecord>();
        queryWrapper.eq("personNO",personNo);
        if (shift.equals("3")){
            String timeEnd = PlusMinusTime(date+" 23:59:59",PMType.PLUS,600);
            queryWrapper.ge("ActionTime",date+" 16:00:00");
            queryWrapper.le("ActionTime",timeEnd);
            return  queryWrapper;
        }
        queryWrapper.ge("ActionTime",date+" 00:00:00");
        queryWrapper.le("ActionTime",date+" 23:59:59");
        return queryWrapper;
    }

//    public static <T> ArrayList<T> getDataBetweenTime(ArrayList<T> data,String fieldName, LocalDateTime start, LocalDateTime end) {
//        ArrayList<T> result = new ArrayList<>();
//        for (T d : data) {
//            Field field = null;
//            try {
//                field = d.getClass().getDeclaredField(fieldName);
//                field.setAccessible(true);
//                try {
//                    LocalDateTime value = (LocalDateTime) field.get(d);
//                    if (value.getTimeStamp().isAfter(start) && d.getTimeStamp().isBefore(end)) {
//                        result.add(d);
//                    }
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//
//            } catch (NoSuchFieldException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//        return result;
  //  }

}
