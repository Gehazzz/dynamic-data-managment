package com.papaya.dynamicdatamanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.repository.OrganizationsRepository;
import com.papaya.dynamicdatamanagement.repository.model.owner.Country;
import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import com.papaya.dynamicdatamanagement.repository.specs.OrganizationSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class UsageLevelTest {

    @Autowired
    OrganizationsRepository organizationsRepository;

    @Autowired
    QueryFormPort queryFormPort;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void findTest(){


    }

}
