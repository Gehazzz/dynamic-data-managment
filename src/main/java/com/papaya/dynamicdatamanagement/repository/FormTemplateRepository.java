package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.FormTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FormTemplateRepository extends JpaRepository<FormTemplate, Long>, QueryByExampleExecutor<FormTemplate>, JpaSpecificationExecutor<FormTemplate> {

}
