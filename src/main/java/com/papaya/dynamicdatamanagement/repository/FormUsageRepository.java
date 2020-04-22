package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.owner.FormUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormUsageRepository extends JpaRepository<FormUsage, Long> {
}
