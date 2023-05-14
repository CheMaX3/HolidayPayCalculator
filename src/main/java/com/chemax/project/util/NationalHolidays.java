package com.chemax.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public enum NationalHolidays {

    NEW_YEAR_HOLIDAY_DAY_1(LocalDate.parse("01-01-2023")),
    NEW_YEAR_HOLIDAY_DAY_2(LocalDate.parse("01-01-2023")),
    NEW_YEAR_HOLIDAY_DAY_3(LocalDate.parse("01-01-2023")),
    NEW_YEAR_HOLIDAY_DAY_4(LocalDate.parse("01-01-2023")),
    NEW_YEAR_HOLIDAY_DAY_5(LocalDate.parse("01-01-2023")),
    NEW_YEAR_HOLIDAY_DAY_6(LocalDate.parse("01-01-2023")),
    ORTHODOX_CHRISTMAS_DAY(LocalDate.parse("01-01-2023")),
    NEW_YEAR_HOLIDAY_DAY_7(LocalDate.parse("01-01-2023")),
    DEFENDER_OF_THE_FATHERLAND_DAY_1(LocalDate.parse("01-01-2023")),
    INTERNATIONAL_WOMEN_DAY(LocalDate.parse("01-01-2023")),
    SPRING_AND_LABOR_DAY(LocalDate.parse("01-01-2023")),
    VICTORY_DAY(LocalDate.parse("01-01-2023")),
    RUSSIA_DAY(LocalDate.parse("01-01-2023")),
    UNITY_DAY(LocalDate.parse("01-01-2023"));

    private final LocalDate holidayDate;

    NationalHolidays(LocalDate holidayDate){
        this.holidayDate = holidayDate;
    }

    public static Set<LocalDate> asLocalDateSet() {
        Set<LocalDate> nationalHolidays = new HashSet<>();
        for (NationalHolidays holiday : NationalHolidays.values()) {
            nationalHolidays.add(holiday.holidayDate);
        }
        return nationalHolidays;
    }
}
