package com.ismail.kocfinansproje.controller;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ismail.kocfinansproje.entity.CreditApplication;
import com.ismail.kocfinansproje.services.CreditApplicationService;


@Controller
public class CreditScoreController {

	@Autowired CreditApplicationService creditApplicationService;
	@RequestMapping(value = "/getCreditScore", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCreditScore(@RequestParam String nationalId,@RequestParam String name,@RequestParam String surname,@RequestParam String monthlySalary){
		JSONObject response = new JSONObject();
		CreditApplication application = new CreditApplication();
		try {
			Double creditScore = creditApplicationService.getCreditScoreByNationalId(nationalId);
			Double creditLimit = creditApplicationService.getCreditLimitByMonthlySalary(Double.parseDouble(monthlySalary), creditScore);
			application.setApplicationTime(new java.sql.Timestamp(System.currentTimeMillis()));
			application.setIdentityNo(nationalId);
			
			if(creditLimit > 0.00){
				application.setIsSuccess("1");
				response.put("DESCRIPTION","Limit tahsis edilmiştir.");
				response.put("LIMIT",String.valueOf(creditLimit)+"TL");
				application.setAssignedLimit(creditLimit.intValue());
			}else{
				application.setIsSuccess("0");
				response.put("DESCRIPTION","Limit tahsis edilememiştir.");
			}
			
		} catch (Exception e) {
			application.setIsSuccess("0");
			response.put("DESCRIPTION",e.getMessage());
		} finally{
			creditApplicationService.save(application);
			return ResponseEntity.ok().body(response.toString());
		}
		
	}
	 

}
