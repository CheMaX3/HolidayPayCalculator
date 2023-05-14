package com.chemax.project.controller;

import com.chemax.project.service.HolidayPayService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

//TODO:назвать нормально
@RestController
public class HolidayPayController {

    private final HolidayPayService service;

    public HolidayPayController(HolidayPayService service) {
        this.service = service;
    }

//    @GetMapping("/calculate/averageSalary={averageSalary}&vacationDaysCount={vacationDaysCount}")
//    @ResponseBody
//    public Double getHolidayPayWithoutInterval(@PathVariable double averageSalary,
//                                               @PathVariable int vacationDaysCount) {
//        return service.calculateWithoutInterval(averageSalary, vacationDaysCount);
//    }

//    @GetMapping("/calculate/averageSalary={averageSalary}&startVacationDay={startVacationDay}&" +
//            "endVacationDay={endVacationDay}")
//    public Double getHolidayPayWithInterval(@PathVariable double averageSalary,
//                                            @PathVariable String startVacationDay,
//                                            @PathVariable String endVacationDay) {
//        return service.calculateWithInterval(averageSalary, startVacationDay, endVacationDay);
//    }

    @GetMapping("/calculate")
    public BigDecimal getHolidayPay(@RequestParam double averageSalary,
                                    @RequestParam int vacationDaysCount,
                                    @RequestParam(required = false) String startVacationDay,
                                    @RequestParam(required = false) String endVacationDay) {
        return service.calculate(averageSalary, vacationDaysCount, startVacationDay, endVacationDay);
    }
}
