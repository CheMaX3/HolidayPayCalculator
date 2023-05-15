package com.chemax.project.service;

import com.chemax.project.util.NationalHolidays;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class VacationPayService {

    private static final BigDecimal AVERAGE_DAYS_IN_MONTH = BigDecimal.valueOf(29.3);
    private static final BigDecimal INCOME_TAX_COEFFICIENT = BigDecimal.valueOf(0.87);

    private int evaluatePayableVacationDays(LocalDate startVacationDate, LocalDate endVacationDate) {
        return (int) startVacationDate.datesUntil(endVacationDate.plusDays(1))
                .filter(vacationDay -> !NationalHolidays.asLocalDateSet().contains(vacationDay)).count();
    }

    public BigDecimal calculate(double averageSalary, int payableVacationDaysCount, LocalDate startVacationDate,
                                LocalDate endVacationDate) {
        if (startVacationDate != null && endVacationDate != null) {
            payableVacationDaysCount = evaluatePayableVacationDays(startVacationDate, endVacationDate);
        }
        return BigDecimal.valueOf(averageSalary).setScale(2, RoundingMode.HALF_UP)
                .divide(AVERAGE_DAYS_IN_MONTH, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(payableVacationDaysCount))
                .multiply(INCOME_TAX_COEFFICIENT).setScale(2, RoundingMode.HALF_UP);
    }
}
