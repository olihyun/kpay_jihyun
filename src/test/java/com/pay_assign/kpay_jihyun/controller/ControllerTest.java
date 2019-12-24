package com.pay_assign.kpay_jihyun.controller;

import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.ThreeTForJson;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;
import com.pay_assign.kpay_jihyun.service.AllTaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AllTaskController.class)
public class ControllerTest {


    private MockMvc mvc;

    @Autowired
    private WebApplicationContext ctx;

    @MockBean
    private AllTaskService allTaskService;

    @Before
    public void mockMvcSetting(){
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
                .alwaysDo(print())
                .build();
    }

    @Test
    public void oneTaskTest() throws Exception{

        OneT oneT = new OneT("2019", "김지현", "00011100", 10);

        List<OneT> testData = new ArrayList<>();
        testData.add(oneT);

        given(allTaskService.getTaskOne()).willReturn(testData);

        //when
        final ResultActions actions = mvc.perform(get("/one")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].year").value("2019"))
                .andExpect(jsonPath("$[0].name").value("김지현"))
                .andExpect(jsonPath("$[0].acctNo").value("00011100"))
                .andExpect(jsonPath("$[0].sumAmt").value(10))
        ;
    }

    @Test
    public void twoTaskTest() throws Exception {

        TwoT twoT = new TwoT("2019", "김지현", "00011100");


        List<TwoT> testData = new ArrayList<>();
        testData.add(twoT);

        given(allTaskService.getTaskTwo()).willReturn(testData);

        //when
        final ResultActions actions = mvc.perform(get("/two")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].year").value("2019"))
                .andExpect(jsonPath("$[0].name").value("김지현"))
                .andExpect(jsonPath("$[0].acctNo").value("00011100"))
        ;
    }

    @Test
    public void threeTaskTest() throws  Exception {
        List<BrThreeFourTForQuery> testDataIn = new ArrayList<>();
        testDataIn.add(new BrThreeFourTForQuery("판교점","Z",100000L));

        ThreeTForJson threeTForJson = new ThreeTForJson("2019", testDataIn);


        List<ThreeTForJson> testData = new ArrayList<>();
        testData.add(threeTForJson);

        given(allTaskService.getTaskThree()).willReturn(testData);

        //when
        final ResultActions actions = mvc.perform(get("/three")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].year").value("2019"))
                .andExpect(jsonPath("$[0].dataList[0].brName").value("판교점"))
                .andExpect(jsonPath("$[0].dataList[0].brCod").value("Z"))
                .andExpect(jsonPath("$[0].dataList[0].sumAmt").value(100000L))
        ;
    }

    @Test
    public void fourTaskTest() throws Exception {
        BrThreeFourTForQuery brThreeFourTForQuery = new BrThreeFourTForQuery("서울점", "1", 1000L);

        List<BrThreeFourTForQuery> testData = new ArrayList<>();
        testData.add(brThreeFourTForQuery);

        given(allTaskService.getTaskFour("서")).willReturn(testData);

        String jsonString="{\"brName\": \"서\"}";

        //when
        final ResultActions actions = mvc.perform(post("/four")
                .content(jsonString)
                .header("Type", " application/json")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brName").value("서울점"))
                .andExpect(jsonPath("$[0].brCod").value("1"))
                .andExpect(jsonPath("$[0].sumAmt").value(1000L))
        ;
    }

}
