package com.chemax.project.controller;

import com.chemax.project.service.HolidayPayService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

//TODO:назвать нормально
@RestController
public class HolidayPayController {

    private final HolidayPayService service;

    public HolidayPayController(HolidayPayService service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public BigDecimal getHolidayPay(@RequestParam double averageSalary,
                                    @RequestParam int payableVacationDaysCount,
                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        LocalDate startVacationDay,
                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        LocalDate endVacationDay) {
        return service.calculate(averageSalary, payableVacationDaysCount, startVacationDay, endVacationDay);
    }
}
