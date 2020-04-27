package com.papaya.dynamicdatamanagement.repository;

import com.papaya.dynamicdatamanagement.repository.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country,String> {

}
