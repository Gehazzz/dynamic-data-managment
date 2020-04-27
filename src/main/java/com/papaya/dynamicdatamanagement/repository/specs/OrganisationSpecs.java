package com.papaya.dynamicdatamanagement.repository.specs;

import com.papaya.dynamicdatamanagement.repository.model.Country;
import com.papaya.dynamicdatamanagement.repository.model.Organisation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class OrganisationSpecs {


    public static Specification<Organisation> getByCountryId(String countryId){
        return (Specification<Organisation>) (root, criteriaQuery, criteriaBuilder) -> {
            Join<Organisation, Country> country = root.join("country");
            return criteriaBuilder.equal(country.get("name"),countryId);
        };
    }

}
