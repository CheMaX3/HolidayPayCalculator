package com.chemax.project.service;

import com.chemax.project.exception.BadRequestException;
import com.chemax.project.util.NationalHolidays;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class VacationPayService {

    private static final BigDecimal AVERAGE_DAYS_IN_MONTH = new BigDecimal("29.3");
    private static final BigDecimal INCOME_TAX_COEFFICIENT = new BigDecimal("0.87");

    private int evaluatePayableVacationDays(LocalDate startVacationDate, LocalDate endVacationDate) {
        return (int) startVacationDate.datesUntil(endVacationDate.plusDays(1))
                .filter(vacationDay -> !NationalHolidays.asLocalDateSet().contains(vacationDay)).count();
    }

    public BigDecimal calculate(String averageSalary, int payableVacationDaysCount, LocalDate startVacationDate,
                                LocalDate endVacationDate) {
        if (Double.parseDouble(averageSalary) < 0) {
            throw new BadRequestException("Значение averageSalary должно быть числом и не должно быть меньше 0. " +
                    "Введенное значение " + averageSalary);
        }
        if (payableVacationDaysCount < 0) {
            throw new BadRequestException("Значение payableVacationCount должно быть целым числом и не должно быть " +
                    "меньше 0. Введенное значение " + payableVacationDaysCount);
        }
        if (startVacationDate != null && endVacationDate != null) {
            payableVacationDaysCount = evaluatePayableVacationDays(startVacationDate, endVacationDate);
        }
        return new BigDecimal(averageSalary).setScale(2, RoundingMode.HALF_UP)
                .divide(AVERAGE_DAYS_IN_MONTH, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(payableVacationDaysCount))
                .multiply(INCOME_TAX_COEFFICIENT).setScale(2, RoundingMode.HALF_UP);
    }
}
