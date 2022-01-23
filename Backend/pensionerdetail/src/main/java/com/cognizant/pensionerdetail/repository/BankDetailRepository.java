package com.cognizant.pensionerdetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pensionerdetail.models.BankDetail;

@Repository
public interface BankDetailRepository extends JpaRepository<BankDetail, String>{

}
