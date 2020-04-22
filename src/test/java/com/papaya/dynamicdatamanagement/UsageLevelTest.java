package com.papaya.dynamicdatamanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.repository.OrganizationsRepository;
import com.papaya.dynamicdatamanagement.repository.model.owner.Country;
import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import com.papaya.dynamicdatamanagement.repository.specs.OrganizationSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@SpringBootTest
public class UsageLevelTest {

    @Autowired
    OrganizationsRepository organizationsRepository;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void findTest(){
        List<Organisation> all = organizationsRepository.findAll();
        List<Organisation> all1 = organizationsRepository.findAll(Example.of(Organisation.builder().country(Country.builder().id("ch").build()).build(), ExampleMatcher.matching().withMatcher("id",genericPropertyMatcher -> genericPropertyMatcher.exact()).withIgnoreNullValues().withIgnoreCase()));
        Organisation organisation = all1.get(0);
        List<Organisation> ch = organizationsRepository.findAll(OrganizationSpecs.getByCountryId("Switzerland"));
        System.out.println(all);
    }

}
