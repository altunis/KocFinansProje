package com.ismail.kocfinansproje.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ismail.kocfinansproje.entity.CreditApplication;
import com.ismail.kocfinansproje.repository.CreditApplicationRepository;

@Component("creditApplicationService")
public class CreditApplicationService {
	private final double CREDIT_LIMIT_FACTOR = 4.00; 
	private final CreditApplicationRepository creditApplicationRepository;
	
	@Autowired
    public CreditApplicationService(CreditApplicationRepository creditApplicationRepository){
        this.creditApplicationRepository = creditApplicationRepository;
    }
	
	public void save(CreditApplication creditApplication){
		creditApplicationRepository.save(creditApplication);
		
	}
	
	
	public List<CreditApplication> findAll(){
		return (List<CreditApplication>) creditApplicationRepository.findAll();
	}
	
	public double getCreditScoreByNationalId(String nationalId){
		double max = 2000.00;
		double min = 0.00;
		return (Math.random() * ((max - min) + 1)) + min;
	}
	public double getCreditLimitByMonthlySalary(double monthlySalary,double creditScore){
		double creditLimit = 0.00;
		if(creditScore < 500){
			creditLimit = 0.00; 
		}else if(creditScore > 500 && creditScore <1000){
			creditLimit = 10000.00;
		}else if(creditScore > 1000){
			creditLimit = monthlySalary * CREDIT_LIMIT_FACTOR;
		}else{
			creditLimit = 0.00;
		}
		return creditLimit;
	}
	
}
