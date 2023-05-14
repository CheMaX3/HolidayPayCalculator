package com.chemax.project.controller;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VacationPayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getVacationPayPositiveTest() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=50000&payableVacationDaysCount=28"))
                .andExpect(status().isOk());
    }

    @Test
    void getVacationPayBadRequestTest() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=hst&payableVacationDaysCount=28"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getHolidayPayTestReturn0() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=5000&payableVacationDaysCount=0"))
                .andExpect(status().isOk()).andExpect(jsonPath("$", IsEqual.equalTo(0.0)));
    }

    @Test
    void getVacationPayWithTwoDatesTest() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=50000&payableVacationDaysCount=28&" +
                        "startVacationDate=14-02-2022&endVacationDate=28-02-2022"))
                .andExpect(status().isOk());
    }

    @Test
    void getVacationPayWithOneDateTest() throws Exception {
        mockMvc.perform(get("/calculate?averageSalary=50000&payableVacationDaysCount=28&" +
                        "startVacationDate=14-02-2022"))
                .andExpect(status().isOk());
    }

    @Test
    void getVacationPayWithoutAverageSalaryTest() throws Exception {
        mockMvc.perform(get("/calculate?payableVacationDaysCount=28"))
                .andExpect(status().is4xxClientError());
    }
}
