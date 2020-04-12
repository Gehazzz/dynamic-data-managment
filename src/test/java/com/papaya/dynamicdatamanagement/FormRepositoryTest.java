package com.papaya.dynamicdatamanagement;

import com.papaya.dynamicdatamanagement.data_model.template.*;
import com.papaya.dynamicdatamanagement.repository.FormRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FormRepositoryTest {
    @Autowired
    FormRepository formRepository;
    @Test
    void formTest(){
        Section section = Section.builder()
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

        InputField inputField = InputField.builder()
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

        List<InputField> fields = new ArrayList<>();
        fields.add(inputField);

        section.setInputFields(fields);

        Form form = Form.builder()
                .label("form")
                .mainSection(section)
                .build();

        formRepository.save(form);
    }
}
