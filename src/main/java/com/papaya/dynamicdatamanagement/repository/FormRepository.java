package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.data_model.template.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
