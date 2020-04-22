package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface OrganizationsRepository extends JpaRepository<Organisation,Long>, JpaSpecificationExecutor<Organisation>, QueryByExampleExecutor<Organisation> {

    List<Organisation> findAllByCountry_Id(String countryId);

    List<Organisation> findAll(Specification<Organisation> orgSpec);
}
