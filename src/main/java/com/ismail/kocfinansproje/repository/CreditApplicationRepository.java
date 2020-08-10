package com.ismail.kocfinansproje.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ismail.kocfinansproje.entity.CreditApplication;


public interface CreditApplicationRepository extends CrudRepository<CreditApplication,Long>{

}
