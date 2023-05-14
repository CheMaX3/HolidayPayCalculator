//package com.chemax.project.controller;
//
//import org.hamcrest.core.IsEqual;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class HolidayPayControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void getHolidayPayPositiveTest() throws Exception {
//        mockMvc.perform(get("/calculate?averageSalary=50000&vacationDaysCount=28"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void getHolidayPayBadRequestTest() throws Exception {
//        mockMvc.perform(get("/calculate?averageSalary=hst&vacationDaysCount=28"))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    void getHolidayPayTestReturn0() throws Exception {
//        mockMvc.perform(get("/calculate?averageSalary=5000&vacationDaysCount=0"))
//                .andExpect(status().isOk()).andExpect(jsonPath("$", IsEqual.equalTo(0.0)));
//    }
//
//}
