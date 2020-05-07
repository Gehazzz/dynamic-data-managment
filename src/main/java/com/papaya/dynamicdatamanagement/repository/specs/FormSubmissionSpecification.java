package com.papaya.dynamicdatamanagement.repository.specs;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.repository.model.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class FormSubmissionSpecification {
    public static Specification<FormSubmission> searchFormSubmissions(FormSubmissionSearch formSubmissionSearch) {
        return (Specification<FormSubmission>) (root, query, criteriaBuilder) -> {
            Join<FormSubmission, User> userJoin = root.join(FormSubmission.Fields.user);
            Join<User, FormUsage> formUsageJoin = userJoin.joinSet(User.Fields.formUsages);
            Join<FormSubmission, FormDetails> formDetailsJoin = root.join(FormSubmission.Fields.formDetails);

            List<Predicate> predicates = new ArrayList<>();

            if (formSubmissionSearch.getCountryIso() != null && !formSubmissionSearch.getCountryIso().isEmpty()){
                Predicate countryIsoValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.countryIso), formSubmissionSearch.getCountryIso());
                predicates.add(countryIsoValue);
            }
            if (formSubmissionSearch.getOrganisationId() != null && formSubmissionSearch.getOrganisationId() != 0L){
                Predicate organisationIdValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.organisationId), formSubmissionSearch.getOrganisationId());
                predicates.add(organisationIdValue);
            }
            if (formSubmissionSearch.getProjectId() != null && formSubmissionSearch.getProjectId() != 0L){
                Predicate projectIdValue = criteriaBuilder.equal(formUsageJoin.get(FormUsage.Fields.projectId), formSubmissionSearch.getProjectId());
                predicates.add(projectIdValue);
            }
            if (formSubmissionSearch.getUserName() != null && !formSubmissionSearch.getUserName().isEmpty()){
                Predicate userNameValue = criteriaBuilder.equal(userJoin.get(User.Fields.userName), formSubmissionSearch.getUserName());
                predicates.add(userNameValue);
            }
            if (formSubmissionSearch.getFormType() != null){
                Predicate formTypeValue = criteriaBuilder.equal(formDetailsJoin.get(FormDetails.Fields.formType), formSubmissionSearch.getFormType());
                predicates.add(formTypeValue);
            }
            if (formSubmissionSearch.getLabel() != null && !formSubmissionSearch.getLabel().isEmpty()){
                Predicate formLabelValue = criteriaBuilder.equal(formDetailsJoin.get(FormDetails.Fields.label), formSubmissionSearch.getLabel());
                predicates.add(formLabelValue);
            }
            if (formSubmissionSearch.getStatus() != null){
                Predicate statusValue = criteriaBuilder.equal(root.get(FormSubmission.Fields.status), formSubmissionSearch.getStatus());
                predicates.add(statusValue);
            }

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
    @Data
    @Builder
    @FieldNameConstants
    public class FormSubmissionSearch{
        String countryIso;
        Long organisationId;
        Long projectId;
        String userName;
        FormType formType;
        String label;
        FormSubmissionStatus status;
    }
}
