package com.papaya.dynamicdatamanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.repository.OrganizationsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
