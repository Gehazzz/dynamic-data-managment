package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrganizationsRepository extends JpaRepository<Organisation,Long>, JpaSpecificationExecutor<Organisation> {

}
