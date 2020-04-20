package com.papaya.dynamicdatamanagement.web;

import com.papaya.dynamicdatamanagement.web.dto.UsageLevelCountryDTO;
import com.papaya.dynamicdatamanagement.web.dto.UsageLevelOrganisationDTO;
import com.papaya.dynamicdatamanagement.web.dto.UsageLevelProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/forms")
public class AdminFormController {
    @GetMapping("/countries")
    public List<UsageLevelCountryDTO> getAllCountries(){
        return null;
    }

    /**
     * http://localhost:8080/forms/countries?organisationIds=1,2,3
     * @param organisationIds
     * @return
     */
    @GetMapping("/countries")
    public List<UsageLevelCountryDTO> getCountriesByOrganizations(@RequestParam List<Long> organisationIds){
        return null;
    }

    @GetMapping("/organisations")
    public List<UsageLevelOrganisationDTO> getAllOrganizations(){
        return null;
    }

    /**
     *
     * @param countriesIso
     * @return
     */
    @GetMapping("/organisations")
    public List<UsageLevelOrganisationDTO> getOrganizationsByCountry(@RequestParam List<String> countriesIso){
        return null;
    }

    @GetMapping
    public List<UsageLevelProjectDTO> getAllProjects(){
        return null;
    }

    @GetMapping
    public List<UsageLevelProjectDTO> getProjectsByCountry(){
        return null;
    }

    @GetMapping
    public List<UsageLevelProjectDTO> getProjectsByOrganization(){
        return null;
    }

    @GetMapping
    public List<UsageLevelProjectDTO> getProjectsByCountryAndOrganization(){
        return null;
    }
}
