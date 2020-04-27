package com.papaya.dynamicdatamanagement;

import com.papaya.dynamicdatamanagement.repository.FormTemplateRepository;
import com.papaya.dynamicdatamanagement.repository.FormUsageRepository;
import com.papaya.dynamicdatamanagement.repository.model.owner.FormUsage;
import com.papaya.dynamicdatamanagement.repository.model.owner.Role;
import com.papaya.dynamicdatamanagement.repository.model.owner.User;
import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import com.papaya.dynamicdatamanagement.repository.specs.FormSpecifications;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FormRepositoryTest {
    @Autowired
    FormTemplateRepository formRepository;
    @Autowired
    FormUsageRepository formUsageRepository;

    @Test
    void searchTest() {
        formRepository.deleteAll();
        formUsageRepository.deleteAll();
        User admin = User.builder().userName("admin-123").build();
        User admin2 = User.builder().userName("admin-us4").build();
        User user = User.builder().userName("super-user").build();
        FormUsage isr = FormUsage.builder().countryIso("ISR").organisationId(23L).projectId(9L).users(List.of(admin, user)).build();
        FormUsage us = FormUsage.builder().countryIso("US").users(List.of(admin2)).build();
        FormTemplate firstForm = FormTemplate.builder().label("form-1").formUsages(List.of(isr, us)).build();

        User manager = User.builder().userName("manager-700").build();
        FormUsage isr2 = FormUsage.builder().countryIso(null).users(List.of(manager)).build();
        FormUsage us2 = FormUsage.builder().countryIso("US").organisationId(17L).build();
        FormTemplate secondForm = FormTemplate.builder().label("form-2").formUsages(List.of(isr2, us2)).build();
        formRepository.save(firstForm);
        formRepository.save(secondForm);
        List<FormTemplate> forms = formRepository.findAll(FormSpecifications.formsByUsageLevel("ISR", 23L, 9L, List.of(manager)));
        forms.forEach(System.out::println);
    }
    @Test
    void severalValuesForFieldSearchTest(){
    }
}
