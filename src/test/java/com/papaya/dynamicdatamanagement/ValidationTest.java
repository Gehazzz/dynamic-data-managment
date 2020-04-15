package com.papaya.dynamicdatamanagement;

import com.papaya.dynamicdatamanagement.service.form.model.elements.main.Form;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootTest
public class ValidationTest {
    @Autowired
    Validator validator;

    @Test
    void validationTest(){
        Form form = new Form();
        Set<ConstraintViolation<Form>> violations =  validator.validate(form);
        violations.forEach(System.out::println);
    }
}
