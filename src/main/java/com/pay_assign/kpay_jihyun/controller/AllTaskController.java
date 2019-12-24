package com.pay_assign.kpay_jihyun.controller;

import com.pay_assign.kpay_jihyun.domain.errorModel.ErrorModerFourT;
import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.ThreeTForJson;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;
import com.pay_assign.kpay_jihyun.domain.post_model.FourTSearchVo;
import com.pay_assign.kpay_jihyun.service.AllTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllTaskController {

    @Autowired
    private AllTaskService allTaskService;

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public ResponseEntity taskOneRun() {

        List<OneT> user = allTaskService.getTaskOne();

        if (user == null) {
            //logger.error("User with id {} not found.", id);
//            return new ResponseEntity(new CustomErrorType("User with id " + id
//                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<OneT>>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/two", method = RequestMethod.GET)
    public ResponseEntity taskTwoRun() {

        List<TwoT> user = allTaskService.getTaskTwo();

        if (user == null) {
            //logger.error("User with id {} not found.", id);
//            return new ResponseEntity(new CustomErrorType("User with id " + id
//                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<TwoT>>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/three", method = RequestMethod.GET)
    public ResponseEntity taskThreeRun() {

        List<ThreeTForJson> user = allTaskService.getTaskThree();

        if (user == null) {
            //logger.error("User with id {} not found.", id);
//            return new ResponseEntity(new CustomErrorType("User with id " + id
//                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ThreeTForJson>>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/four", method = RequestMethod.POST)
    public ResponseEntity isPostTest(@RequestBody FourTSearchVo searchVo) {

        FourTSearchVo searchVO = searchVo;

        String brName = searchVo.getBrName();

        if(brName == null || brName.equals("")){
            return getBr_code_not_found_error();
        }

        List<BrThreeFourTForQuery> result = allTaskService.getTaskFour(brName);

        if(result == null || result.size() == 0){
            return getBr_code_not_found_error();
        }

        return new ResponseEntity<List<BrThreeFourTForQuery>>(result, HttpStatus.OK);
    }

    private ResponseEntity getBr_code_not_found_error() {
        return new ResponseEntity(new ErrorModerFourT(HttpStatus.NOT_FOUND.toString(),
                "br code not found error"), HttpStatus.NOT_FOUND);
    }

}

