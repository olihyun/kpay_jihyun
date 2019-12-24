package com.pay_assign.kpay_jihyun.domain.repository;

import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;


import java.util.List;

public interface AllTRepository {

    List<OneT> findByYear(String year);

    List<TwoT> findByYearTwo(String year);

    List<BrThreeFourTForQuery> findByYearThree(String year);

    List<BrThreeFourTForQuery> findByBrNmFour(String brName);
}
