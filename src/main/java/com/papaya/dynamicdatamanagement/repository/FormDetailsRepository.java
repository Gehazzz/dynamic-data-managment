package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.FormDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FormDetailsRepository extends JpaRepository<FormDetails, Long>, QueryByExampleExecutor<FormDetails>, JpaSpecificationExecutor<FormDetails> {

}
