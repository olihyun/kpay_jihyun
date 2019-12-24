package com.pay_assign.kpay_jihyun.repository_test;

import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.ThreeTForJson;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;
import com.pay_assign.kpay_jihyun.domain.repository.JdbcAllTRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JdbcTest
@ActiveProfiles("application.properties")
@ComponentScan("com.pay_assign.kpay_jihyun.domain.repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired(required = true)
    JdbcAllTRepository jdbcAllTRepository;

    @Test
    public void oneTaskTest(){

        List<OneT> list = jdbcAllTRepository.findByYear("2018");

        Collections.sort(list, (o1,o2) -> Long.compare(o2.getSumAmt(), o1.getSumAmt()));

        assertThat(list.get(0).getName().equals("테드"));
        assertThat(list.get(0).getAcctNo().equals("11111114"));
        assertThat(list.get(0).getYear().equals("2018"));
        assertThat(list.get(0).getSumAmt() == 28992000);

        list = jdbcAllTRepository.findByYear("2019");

        Collections.sort(list, (o1,o2) -> Long.compare(o2.getSumAmt(), o1.getSumAmt()));

        assertThat(list.get(0).getName().equals("에이스"));
        assertThat(list.get(0).getAcctNo().equals("11111112"));
        assertThat(list.get(0).getYear().equals("2019"));
        assertThat(list.get(0).getSumAmt() == 40998400);
    }

    @Test
    public void twoTaskTest(){
        List<TwoT> list = jdbcAllTRepository.findByYearTwo("2018");

        assertThat(list.get(0).getName().equals("사라"));
        assertThat(list.get(0).getAcctNo().equals("11111115"));
        assertThat(list.get(0).getYear().equals("2018"));
    }

    @Test
    public void threeTaskTest(){
        List<BrThreeFourTForQuery> list = jdbcAllTRepository.findByYearThree("2018");

        assertThat(list.get(0).getBrName().equals("분당점"));
        assertThat(list.get(0).getSumAmt() == 38500000);
        assertThat(list.get(0).getBrCod().equals("B"));;
    }

    @Test
    public void fourTaskTest(){
        List<BrThreeFourTForQuery> list = jdbcAllTRepository.findByBrNmFour("판교");

        assertThat(list.get(0).getBrName().equals("판교점"));
        assertThat(list.get(0).getSumAmt() == 171210000);
        assertThat(list.get(0).getBrCod().equals("A"));;
    }
}
