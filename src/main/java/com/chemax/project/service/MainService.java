package com.chemax.project.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    public Double calculate(double averageSalary, int vacationDaysCount) {
        double averageDaysInMonth = 29.3;
        return averageSalary / averageDaysInMonth * vacationDaysCount;
    }
}
