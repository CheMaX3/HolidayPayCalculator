package com.chemax.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class HolidayPayServiceTest {

    @Autowired
    private HolidayPayService service;

    @Test
    void calculateWithoutIntervalPositiveTest() {
        BigDecimal actual = service.calculateWithoutInterval(50000, 28);
        BigDecimal actualWithVacationDaysCountIs0 = service.calculateWithoutInterval(50000, 0);
        assertNotNull(actual);
        assertEquals(BigDecimal.ZERO, actualWithVacationDaysCountIs0);
    }



}
