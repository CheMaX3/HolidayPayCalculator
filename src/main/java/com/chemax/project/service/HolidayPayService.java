package com.chemax.project.service;

import com.chemax.project.util.NationalHolidays;
import com.chemax.project.util.NationalHolidays2022;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private final NationalHolidays nationalHolidays;


    public HolidayPayService(NationalHolidays nationalHolidays) {
        this.nationalHolidays = nationalHolidays;
    }

    private int evaluatePayableVacationDays(LocalDate startVacationDay, LocalDate endVacationDay) {
//        LocalDate startVacationDate = LocalDate.parse(startVacationDay, FORMATTER);
//        LocalDate endVacationDate = LocalDate.parse(endVacationDay, FORMATTER);
        Set<LocalDate> vacationDays = new HashSet<>();
        while(!startVacationDay.isEqual(endVacationDay)) {
            vacationDays.add(startVacationDay);
            startVacationDay = startVacationDay.plusDays(1);
        }
        vacationDays.removeAll(NationalHolidays.asLocalDateSet());
        return vacationDays.size();
    }


    //TODO:подумать как лучше
    public BigDecimal calculate(double averageSalary, int vacationDaysCount, LocalDate startVacationDay,
                                LocalDate endVacationDay) {
        if (startVacationDay != null && endVacationDay != null) {
            vacationDaysCount = evaluatePayableVacationDays(startVacationDay, endVacationDay);
        }
        return BigDecimal.valueOf(averageSalary).divide(AVERAGE_DAYS_IN_MONTH, RoundingMode.UP)
                    .multiply(BigDecimal.valueOf(vacationDaysCount));
    }
}
