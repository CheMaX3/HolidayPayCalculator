package com.chemax.project.controller;

import com.chemax.project.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping("/calculate/averageSalary={averageSalary}&vacationDaysCount={vacationDaysCount}")
    @ResponseBody
    public Double getHolidayPay(@PathVariable double averageSalary, @PathVariable int vacationDaysCount) {
        return service.calculate(averageSalary, vacationDaysCount);
    }
}
