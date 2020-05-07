package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.FormSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FormSubmissionRepository extends JpaRepository<FormSubmission, Long>, QueryByExampleExecutor<FormSubmission>, JpaSpecificationExecutor<FormSubmission> {
}
