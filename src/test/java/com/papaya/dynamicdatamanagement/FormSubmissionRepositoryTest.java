package com.papaya.dynamicdatamanagement;

import com.papaya.dynamicdatamanagement.repository.FormDetailsRepository;
import com.papaya.dynamicdatamanagement.repository.FormSubmissionRepository;
import com.papaya.dynamicdatamanagement.repository.model.*;
import com.papaya.dynamicdatamanagement.repository.specs.FormSubmissionSearch;
import com.papaya.dynamicdatamanagement.repository.specs.FormSubmissionSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class FormSubmissionRepositoryTest {
    @Autowired
    FormSubmissionRepository formSubmissionRepository;
    @Autowired
    FormDetailsRepository formDetailsRepository;

    @Test
    void dynamicSearchTest() {
        FormSubmission formSubmissionDetails = createFormSubmissionDetails();
        System.out.println(formSubmissionDetails);
        formSubmissionRepository.save(formSubmissionDetails);
        FormSubmissionSearch searchByUserName = FormSubmissionSearch.builder()
                .countryIso(null)
                .organisationId(null)
                .projectId(null)
                .userName("Papaya user")
                .status(null)
                .formType(null)
                .label(null)
                .build();
        List<FormSubmission> all = formSubmissionRepository.findAll(FormSubmissionSpecification.searchFormSubmissions(searchByUserName));
        all.forEach(System.out::println);
    }

    FormSubmission createFormSubmissionDetails(){
        FormDetails formDetails = createFormDetails();
        User user = createUser(formDetails.getFormUsages());
        FormSubmission formSubmission = FormSubmission.builder()
                .formDetails(formDetails)
                .mainSectionSubmission(createSectionSubmissionDetails(formDetails.getMainSection()))
                .status(FormSubmissionStatus.DRAFT)
                .user(user)
                .build();
        user.setFormSubmissions(List.of(formSubmission));
        return formSubmission;
    }

    private User createUser(Set<FormUsage> formUsages) {
        Optional<FormUsage> formUsageOptional = formUsages.stream().findFirst();
        FormUsage formUsage = formUsageOptional.orElseThrow();
        return User.builder()
                .userName("Papaya user")
                .email("email@papayaglobal.com")
                .formUsages(formUsages)
                .build();
    }

    SectionSubmission createSectionSubmissionDetails(SectionDetails sectionDetails) {
        return SectionSubmission.builder()
                .section(sectionDetails)
                //.sectionSubmission(createSectionSubmissionDetails(sectionDetails.getParentSection()))
                //.sectionSubmissions(sectionDetails.getSections().stream()
                       // .map(this::createSectionSubmissionDetails).collect(Collectors.toList()))
                .values(createValues(sectionDetails))
                .build();
    }

    private List<Value> createValues(SectionDetails sectionDetails) {
        return sectionDetails.getInputFields().stream()
                .map(inputFieldDetails -> Value.builder()
                    .inputFieldDetails(inputFieldDetails)
                    .type(inputFieldDetails.getType())
                    .value("Some value")
                    .validationRules(new HashSet<>(inputFieldDetails.getValidationRules()))
                    .build()
                )
                .collect(Collectors.toList());
    }

    FormDetails createFormDetails() {
        SectionDetails section = SectionDetails.builder()
                .label("section label")
                .index(0)
                .build();

        ValidationRule validationRule = ValidationRule.builder()
                .min(2)
                .message("Word length should be more then 2")
                .constraint(Constraint.SIZE)
                .build();

        List<ValidationRule> validationRules = new ArrayList<>();
        validationRules.add(validationRule);

        InputFieldDetails inputFieldDetails = InputFieldDetails.builder()
                .label("input label")
                .hint("this is hint")
                .index(0)
                .placeholder("placeholder")
                .required(true)
                .requiredMessage("You should fill this input")
                .type(InputJavaType.STRING_TYPE)
                .parentSection(section)
                .validationRules(validationRules)
                .build();

        List<InputFieldDetails> fields = new ArrayList<>();
        fields.add(inputFieldDetails);

        section.setInputFields(fields);

        FormDetails formDetails = FormDetails.builder()
                .label("form")
                .mainSection(section)
                .formUsages(Set.of(FormUsage.builder().countryIso("ch").projectId(1L).build()))
                .build();
        return formDetails;
    }

}
