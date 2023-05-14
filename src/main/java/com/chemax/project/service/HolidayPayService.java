package com.chemax.project.service;

import com.chemax.project.national_holidays.NationalHolidays;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

//TODO:назвать нормально, переделать
@Service
public class HolidayPayService {

    private static final BigDecimal AVERAGE_DAYS_IN_MONTH = BigDecimal.valueOf(29.3);

    private final NationalHolidays nationalHolidays;


    public HolidayPayService(NationalHolidays nationalHolidays) {
        this.nationalHolidays = nationalHolidays;
    }

    private int evaluatePayableVacationDays(String startVacationDay, String endVacationDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startVacationDate = LocalDate.parse(startVacationDay, formatter);
        LocalDate endVacationDate = LocalDate.parse(endVacationDay, formatter);
        LocalDate vacationDay = startVacationDate;
        Set<LocalDate> vacationDays = new HashSet<>();
        while(!vacationDay.isEqual(endVacationDate)) {
            vacationDays.add(vacationDay);
            vacationDay = vacationDay.plusDays(1);
        }
        vacationDays.removeAll(nationalHolidays.getNationalHolidays());
        return vacationDays.size();
    }


    //TODO:подумать как лучше
    public BigDecimal calculate(double averageSalary, int vacationDaysCount) {
        return BigDecimal.valueOf(averageSalary).divide(AVERAGE_DAYS_IN_MONTH, RoundingMode.UP)
                .multiply(BigDecimal.valueOf(vacationDaysCount));
    }
//
//    public BigDecimal calculateWithInterval(double averageSalary, String startVacationDay, String endVacationDay) {
//        return averageSalary / AVERAGE_DAYS_IN_MONTH * evaluatePayableVacationDays(startVacationDay, endVacationDay);
//    }
}
