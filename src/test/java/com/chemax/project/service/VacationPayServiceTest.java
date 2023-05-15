package com.chemax.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VacationPayServiceTest {

    @Autowired
    private VacationPayService service;

    @Test
    void calculateTest() {
        BigDecimal actual = service.calculate(50000, 28, null
                , null);
        BigDecimal actualWithPayableVacationDaysCountIs0 = service.calculate(50000, 0
                , null, null);
        BigDecimal actualWithStartAndEndVacationDatesWithoutNationalHolidays =
                service.calculate(50000, 28, LocalDate.parse("2023-07-01")
                        , LocalDate.parse("2023-07-14"));
        BigDecimal actualWithStartAndEndVacationDatesWithOneNationalHoliday =
                service.calculate(50000, 10, LocalDate.parse("2023-06-01"),
                        LocalDate.parse("2023-06-14"));
        BigDecimal actualWithOneDateInRequest = service.calculate(50000, 14,
                LocalDate.parse("2023-07-01"), null);
        assertNotNull(actual);
        assertEquals(BigDecimal.ZERO.setScale(2), actualWithPayableVacationDaysCountIs0);
        assertEquals(actualWithStartAndEndVacationDatesWithoutNationalHolidays, BigDecimal.valueOf(20784.93));
        assertEquals(actualWithStartAndEndVacationDatesWithOneNationalHoliday, BigDecimal.valueOf(19300.29));
        assertEquals(actualWithOneDateInRequest, BigDecimal.valueOf(20784.93));
    }
}
