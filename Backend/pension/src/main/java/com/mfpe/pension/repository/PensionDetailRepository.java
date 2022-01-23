package com.mfpe.pension.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfpe.pension.model.PensionDetail;

public interface PensionDetailRepository extends JpaRepository<PensionDetail, String> {

}
