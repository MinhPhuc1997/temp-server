package minhphuc.serverjva.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class DateTimeUtils {
    public static void setDefaultTimeZone(String timezone) {
        TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }

    public static LocalDateTime toLocalDateTime(String datetimeString, String timezone) {
        ZoneId zoneId = ZoneId.of(timezone);
        return LocalDateTime.parse(datetimeString).atZone(zoneId).toLocalDateTime();
    }
}
