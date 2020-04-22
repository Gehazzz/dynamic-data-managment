package com.papaya.dynamicdatamanagement.repository.specs;

import com.papaya.dynamicdatamanagement.repository.model.owner.FormUsage;
import com.papaya.dynamicdatamanagement.repository.model.owner.Role;
import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Stream;

public class FormSpecifications {
    public static Specification<FormTemplate> formsByUsageLevel(String countryIso, Long organisationId, Long projectId, List<Role> roleList) {
        return (Specification<FormTemplate>) (root, query, criteriaBuilder) -> {
            ListJoin<FormTemplate, FormUsage> formUsageJoin = root.joinList(FormTemplate.Fields.formUsages);
            ListJoin<FormUsage, Role> roleJoin = formUsageJoin.joinList(FormUsage.Fields.roles);

            Predicate countryIsoValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.countryIso), countryIso);
            Predicate countryIsoNull = criteriaBuilder.isNull(formUsageJoin.get(FormUsage.Fields.countryIso));
            Predicate countryIsoOrStatement = criteriaBuilder.or(countryIsoValue, countryIsoNull);

            Predicate organisationIdValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.organisationId), organisationId);
            Predicate organisationIdNull = criteriaBuilder.isNull(formUsageJoin.get(FormUsage.Fields.organisationId));
            Predicate organisationIdOrStatement = criteriaBuilder.or(organisationIdValue, organisationIdNull);

            Predicate projectIdValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.projectId), projectId);
            Predicate projectIdNull = criteriaBuilder.isNull(formUsageJoin.get(FormUsage.Fields.projectId));
            Predicate projectIdOrStatement = criteriaBuilder.or(projectIdValue, projectIdNull);

            if (roleList.isEmpty()) {
                return criteriaBuilder.and(countryIsoOrStatement, organisationIdOrStatement, projectIdOrStatement);
            } else {
                Stream<Predicate> roleValues = roleList.stream()
                        .map(role -> {
                            Predicate id = criteriaBuilder.equal(roleJoin.get(Role.Fields.id), role.getId());
                            Predicate code = criteriaBuilder.equal(roleJoin.get(Role.Fields.code), role.getCode());
                            Predicate title = criteriaBuilder.equal(roleJoin.get(Role.Fields.title), role.getTitle());
                            return criteriaBuilder.and(id, code, title);
                        });
                Predicate roleEmpty = criteriaBuilder.isEmpty(formUsageJoin.get(FormUsage.Fields.roles));

                Predicate rolesOrStatement = criteriaBuilder.or(Stream.concat(Stream.of(roleEmpty), roleValues).toArray(Predicate[]::new));

                return criteriaBuilder.and(countryIsoOrStatement, organisationIdOrStatement, projectIdOrStatement, rolesOrStatement);
            }
        };
    }
}
