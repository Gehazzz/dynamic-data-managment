package com.papaya.dynamicdatamanagement.repository.specs;

import com.papaya.dynamicdatamanagement.repository.model.owner.Country;
import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import org.hibernate.query.criteria.internal.path.SingularAttributeJoin;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class OrganizationSpecs {


    public static Specification<Organisation> getByCountryId(String countryId){
        return (Specification<Organisation>) (root, criteriaQuery, criteriaBuilder) -> {
            Join<Organisation, Country> country = root.join("country");
            return criteriaBuilder.equal(country.get("name"),countryId);
        };
    }

}
