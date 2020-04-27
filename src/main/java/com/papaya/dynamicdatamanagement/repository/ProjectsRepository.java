package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByCountry_Id(String countryId);

    List<Project> findAllByOrganisation_Id(Long orgId);

}
