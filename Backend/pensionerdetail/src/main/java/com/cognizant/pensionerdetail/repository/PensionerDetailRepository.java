package com.cognizant.pensionerdetail.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pensionerdetail.models.PensionerDetail;

@Repository
public interface PensionerDetailRepository extends JpaRepository<PensionerDetail, String>{
	
	public Optional<PensionerDetail> findById(String name);
	
}
