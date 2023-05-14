package com.chemax.project.national_holidays;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//TODO:через enum
@Component
public class NationalHolidays {

    public Set<LocalDate> getNationalHolidays() {
        Set<LocalDate> nationalHolidays = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        nationalHolidays.add(LocalDate.parse("01-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("02-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("03-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("04-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("05-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("06-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("07-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("08-01-2023", formatter));
        nationalHolidays.add(LocalDate.parse("23-02-2023", formatter));
        nationalHolidays.add(LocalDate.parse("24-02-2023", formatter));
        nationalHolidays.add(LocalDate.parse("08-03-2023", formatter));
        nationalHolidays.add(LocalDate.parse("01-05-2023", formatter));
        nationalHolidays.add(LocalDate.parse("08-05-2023", formatter));
        nationalHolidays.add(LocalDate.parse("09-05-2023", formatter));
        nationalHolidays.add(LocalDate.parse("12-06-2023", formatter));
        nationalHolidays.add(LocalDate.parse("06-11-2023", formatter));
        return nationalHolidays;
    }

}
