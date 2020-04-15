package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.data_model.template.FormTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<FormTemplate, Long> {
}
