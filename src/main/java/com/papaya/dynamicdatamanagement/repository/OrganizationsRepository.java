package com.papaya.dynamicdatamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrganizationsRepository extends JpaRepository<Organisation,Long>, JpaSpecificationExecutor<Organisation> {

}
