package com.chemax.project.service;

import com.chemax.project.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VacationPayServiceTest {

    @Autowired
    private VacationPayService service;

    private final BigDecimal RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_28_AND_MULTIPLICATION_TO_0_87
            = new BigDecimal("41569.85");
    private final BigDecimal RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_14_AND_MULTIPLICATION_TO_0_87
            = new BigDecimal("20784.93");
    private final BigDecimal RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_13_AND_MULTIPLICATION_TO_0_87
            = new BigDecimal("19300.29");

    @Test
    void positiveCalculateTest() {
        BigDecimal actualWithGoodRequest = service.calculate("50000", 28
                , null
                , null);
        BigDecimal actualWithPayableVacationDaysCountIs0 = service.calculate("50000", 0
                , null, null);
        assertEquals(RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_28_AND_MULTIPLICATION_TO_0_87
                , actualWithGoodRequest);
        assertEquals(BigDecimal.ZERO.setScale(2), actualWithPayableVacationDaysCountIs0);
    }

    @Test
    void negativeCalculateTest() {
        assertThrows(BadRequestException.class, () ->  service.calculate("10", -5
                , null, null));
        assertThrows(BadRequestException.class, () ->  service.calculate("-10", 5
                , null, null));
    }

    @Test
    void calculationWithEvaluationPayableVacationDaysPositiveTest() {
        BigDecimal actualWithStartAndEndVacationDatesWithoutNationalHolidays =
                service.calculate("50000", 28, LocalDate.parse("2023-07-01")
                        , LocalDate.parse("2023-07-14"));
        BigDecimal actualWithStartAndEndVacationDatesWithOneNationalHoliday =
                service.calculate("50000", 10, LocalDate.parse("2023-06-01"),
                        LocalDate.parse("2023-06-14"));
        BigDecimal actualWithOneDateInRequest = service.calculate("50000", 14,
                LocalDate.parse("2023-07-01"), null);
        assertEquals(RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_14_AND_MULTIPLICATION_TO_0_87
                , actualWithStartAndEndVacationDatesWithoutNationalHolidays);
        assertEquals(RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_13_AND_MULTIPLICATION_TO_0_87
                , actualWithStartAndEndVacationDatesWithOneNationalHoliday);
        assertEquals(RESULT_OF_DIVISION_50000_TO_29_3_AND_MULTIPLICATION_TO_14_AND_MULTIPLICATION_TO_0_87
                , actualWithOneDateInRequest);
    }

    @Test
    void calculationWithStartVacationDateLaterThenEndVacationDateTest() {
        assertThrows(IllegalArgumentException.class, () -> service.calculate("50000"
                , 28, LocalDate.parse("2023-07-01"), LocalDate.parse("2023-06-01")));
    }
}
