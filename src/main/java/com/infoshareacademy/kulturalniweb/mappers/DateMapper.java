package com.infoshareacademy.kulturalniweb.mappers;

import com.infoshareacademy.kulturalniweb.entities.event.EventEntity;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

@Component
public class DateMapper {
    public Boolean isFirstPeriod = true;
    Period period;

    public EventEntity map(EventEntity eventEntity) {
        LocalDate presentDay = LocalDate.now();

        String endDateDate = eventEntity.getEndDateDate();
        String endDateDateCorrected = mapDate(endDateDate, presentDay);
        eventEntity.setEndDateDate(endDateDateCorrected);

        String startDateDate = eventEntity.getStartDateDate();
        String startDateDateCorrected = mapDate(startDateDate, presentDay);
        eventEntity.setStartDateDate(startDateDateCorrected);

        return eventEntity;
    }

    public String mapDate(String inputDate, LocalDate presentDay) {
        LocalDate date = LocalDate.parse(inputDate);

        if(isFirstPeriod) {
            period = Period.between(date, presentDay);
            isFirstPeriod = false;
        }

        LocalDate result = date.plusYears(period.getYears()).plusMonths(period.getMonths()).plusDays(period.getDays() - 2);
        //System.out.println(period.getDays() + "   " + period.getMonths() + "   result: " + result.toString() + "  period: " + period);
       return result.toString();
    }
}
