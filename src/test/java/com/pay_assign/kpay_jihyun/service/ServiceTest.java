package com.pay_assign.kpay_jihyun.service;


import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.ThreeTForJson;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JdbcTest
@ActiveProfiles("application.properties")
@ComponentScan("com.pay_assign.pay_jihyun")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTest {

    @Autowired
    private AllTaskService allTaskService;

    @Test
    public void oneTaskTest(){

        List<OneT> list = allTaskService.getTaskOne();

        assertThat(list.get(0).getName().equals("테드"));
        assertThat(list.get(0).getAcctNo().equals("11111114"));
        assertThat(list.get(0).getYear().equals("2018"));
        assertThat(list.get(0).getSumAmt() == 28992000);

        assertThat(list.get(0).getName().equals("에이스"));
        assertThat(list.get(0).getAcctNo().equals("11111112"));
        assertThat(list.get(0).getYear().equals("2019"));
        assertThat(list.get(0).getSumAmt() == 40998400);
    }

    @Test
    public void twoTaskTest(){

        List<TwoT> list = allTaskService.getTaskTwo();

        assertThat(list.get(0).getName().equals("사라"));
        assertThat(list.get(0).getAcctNo().equals("11111115"));
        assertThat(list.get(0).getYear().equals("2018"));
    }

    @Test
    public void threeTaskTest(){

        List<ThreeTForJson> list = allTaskService.getTaskThree();

        assertThat(list.get(0).getYear().equals("2018"));
        assertThat(list.get(0).getDataList().get(0).getBrName().equals("분당점"));
        assertThat(list.get(0).getDataList().get(0).getSumAmt() == 38500000);
        assertThat(list.get(0).getDataList().get(0).getBrCod().equals("B"));
    }

    @Test
    public void fourTaskTest(){

        List<BrThreeFourTForQuery> list = allTaskService.getTaskFour("판교점");

        assertThat(list.get(0).getBrName().equals("판교점"));
        assertThat(list.get(0).getSumAmt() == 171210000);
        assertThat(list.get(0).getBrCod().equals("A"));
    }
}
