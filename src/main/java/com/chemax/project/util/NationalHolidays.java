package com.chemax.project.util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public enum NationalHolidays {

    NEW_YEAR_HOLIDAY_DAY_1(LocalDate.parse("2023-01-01")),
    NEW_YEAR_HOLIDAY_DAY_2(LocalDate.parse("2023-01-02")),
    NEW_YEAR_HOLIDAY_DAY_3(LocalDate.parse("2023-01-03")),
    NEW_YEAR_HOLIDAY_DAY_4(LocalDate.parse("2023-01-04")),
    NEW_YEAR_HOLIDAY_DAY_5(LocalDate.parse("2023-01-05")),
    NEW_YEAR_HOLIDAY_DAY_6(LocalDate.parse("2023-01-06")),
    ORTHODOX_CHRISTMAS_DAY(LocalDate.parse("2023-01-07")),
    NEW_YEAR_HOLIDAY_DAY_7(LocalDate.parse("2023-01-08")),
    DEFENDER_OF_THE_FATHERLAND_DAY_1(LocalDate.parse("2023-02-23")),
    INTERNATIONAL_WOMEN_DAY(LocalDate.parse("2023-03-08")),
    SPRING_AND_LABOR_DAY(LocalDate.parse("2023-05-01")),
    VICTORY_DAY(LocalDate.parse("2023-05-09")),
    RUSSIA_DAY(LocalDate.parse("2023-06-12")),
    UNITY_DAY(LocalDate.parse("2023-11-04"));

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
