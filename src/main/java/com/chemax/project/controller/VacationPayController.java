package com.chemax.project.controller;

import com.chemax.project.service.VacationPayService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class VacationPayController {

    private final VacationPayService service;

    public VacationPayController(VacationPayService service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public BigDecimal getVacationPay(@RequestParam String averageSalary,
                                     @RequestParam int payableVacationDaysCount,
                                     @RequestParam(required = false)
                                         @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startVacationDate,
                                     @RequestParam(required = false)
                                         @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endVacationDate) {
        return service.calculate(averageSalary, payableVacationDaysCount, startVacationDate, endVacationDate);
    }
}
