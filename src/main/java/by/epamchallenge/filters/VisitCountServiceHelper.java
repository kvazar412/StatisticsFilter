package by.epamchallenge.filters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class VisitCountServiceHelper {

    protected static Date getFirstTimeDate() {
        LocalDateTime firstTimeLtd = LocalTime.of(LocalTime.now().plusHours(1).getHour(), 0).atDate(LocalDate.now());
        Date firstTimeDate = Date.from(firstTimeLtd.atZone(ZoneId.systemDefault()).toInstant());
        return firstTimeDate;
    }
}