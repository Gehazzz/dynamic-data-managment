package com.papaya.dynamicdatamanagement.repository.specs;

import com.papaya.dynamicdatamanagement.repository.model.FormUsage;
import com.papaya.dynamicdatamanagement.repository.model.User;
import com.papaya.dynamicdatamanagement.repository.model.FormTemplate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FormSpecifications {
    public static Specification<FormTemplate> formsByUsageLevel(String countryIso, Long organisationId, Long projectId, List<User> userList) {
        return (Specification<FormTemplate>) (root, query, criteriaBuilder) -> {
            ListJoin<FormTemplate, FormUsage> formUsageJoin = root.joinList(FormTemplate.Fields.formUsages);
            ListJoin<FormUsage, User> userJoin = formUsageJoin.joinList(FormUsage.Fields.users);

            List<Predicate> predicates = new ArrayList<>();

            Predicate countryIsoValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.countryIso), countryIso);
            Predicate countryIsoNull = criteriaBuilder.isNull(formUsageJoin.get(FormUsage.Fields.countryIso));
            //Predicate countryIsoOrStatement = criteriaBuilder.or(countryIsoValue, countryIsoNull);
            if (!StringUtils.isEmpty(countryIso)) predicates.add(criteriaBuilder.or(countryIsoValue, countryIsoNull));

            Predicate organisationIdValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.organisationId), organisationId);
            Predicate organisationIdNull = criteriaBuilder.isNull(formUsageJoin.get(FormUsage.Fields.organisationId));
            //Predicate organisationIdOrStatement = criteriaBuilder.or(organisationIdValue, organisationIdNull);
            if (organisationId != null) predicates.add(criteriaBuilder.or(organisationIdValue, organisationIdNull));

            Predicate projectIdValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.projectId), projectId);
            Predicate projectIdNull = criteriaBuilder.isNull(formUsageJoin.get(FormUsage.Fields.projectId));
            //Predicate projectIdOrStatement = criteriaBuilder.or(projectIdValue, projectIdNull);
            if (projectId != null) predicates.add(criteriaBuilder.or(projectIdValue, projectIdNull));

            if (userList == null || userList.isEmpty()) {
                //return criteriaBuilder.and(countryIsoOrStatement, organisationIdOrStatement, projectIdOrStatement);
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            } else {
                Stream<Predicate> roleValues = userList.stream()
                        .map(user -> {
                            Predicate id = criteriaBuilder.equal(userJoin.get(User.Fields.id), user.getId());
                            Predicate userName = criteriaBuilder.equal(userJoin.get(User.Fields.userName), user.getUserName());
                            Predicate email = criteriaBuilder.equal(userJoin.get(User.Fields.email), user.getEmail());
                            return criteriaBuilder.and(id, userName, email);
                        });
                Predicate roleEmpty = criteriaBuilder.isEmpty(formUsageJoin.get(FormUsage.Fields.users));

                Predicate rolesOrStatement = criteriaBuilder.or(Stream.concat(Stream.of(roleEmpty), roleValues).toArray(Predicate[]::new));
                predicates.add(rolesOrStatement);
                //return criteriaBuilder.and(countryIsoOrStatement, organisationIdOrStatement, projectIdOrStatement, rolesOrStatement);
                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
}
