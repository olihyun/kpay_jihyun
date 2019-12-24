package com.pay_assign.kpay_jihyun.service;


import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.ThreeTForJson;
import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;
import com.pay_assign.kpay_jihyun.domain.repository.JdbcAllTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class AllTaskService {

    @Autowired
    private JdbcAllTRepository jdbcAllTRepository;


    public List<OneT> getTaskOne(){

        List<OneT> listBy2018 = jdbcAllTRepository.findByYear("2018");
        List<OneT> listBy2019 = jdbcAllTRepository.findByYear("2019");

        Collections.sort(listBy2018, (ob1, ob2) -> {
             return Long.compare(ob2.getSumAmt(), ob1.getSumAmt());
        });

        Collections.sort(listBy2019, (ob1, ob2) -> {
            return Long.compare(ob2.getSumAmt(), ob1.getSumAmt());
        });

        List<OneT> result = new ArrayList<>();

        result.add(listBy2018.get(0));
        result.add(listBy2019.get(0));

        return result;
    }

    public List<TwoT> getTaskTwo(){

        List<TwoT> opBy2018 = jdbcAllTRepository.findByYearTwo("2018");
        List<TwoT> opBy2019 = jdbcAllTRepository.findByYearTwo("2019");

        List<TwoT> result = new ArrayList<>();

        for(TwoT t : opBy2018){
            result.add(t);
        }

        for(TwoT t : opBy2019){
            result.add(t);
        }

        return  result;
    }

    public List<ThreeTForJson> getTaskThree(){

        List<ThreeTForJson> result = new ArrayList<>();

        List<BrThreeFourTForQuery> listBy2018 = jdbcAllTRepository.findByYearThree("2018");

        List<BrThreeFourTForQuery> listBy2019 = jdbcAllTRepository.findByYearThree("2019");

        result.add(new ThreeTForJson("2018", listBy2018));
        result.add(new ThreeTForJson("2019", listBy2019));

        return result;
    }

    public List<BrThreeFourTForQuery> getTaskFour(String brName){
        return jdbcAllTRepository.findByBrNmFour(brName);
    }


}
