package com.papaya.dynamicdatamanagement.web.admin;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usage-level/forms")
public class UsageLevelController {
    @GetMapping("/countries")
    public List<UsageLevelCountryDTO> getAllCountries() {
        return null;
    }

    /**
     * http://localhost:8080/forms/countries?organisationIds=1,2,3
     *
     * @param organisationsId
     * @return
     */
    @GetMapping(value = "/countries", params = "organisationsId")
    public List<UsageLevelCountryDTO> getCountriesByOrganizations(@RequestParam List<Long> organisationsId) {
        return null;
    }

    @GetMapping("/organisations")
    public List<UsageLevelOrganisationDTO> getAllOrganizations() {
        return null;
    }

    /**
     * @param countriesIso
     * @return
     */
    @GetMapping(value = "/organisations", params = "countriesIso")
    public List<UsageLevelOrganisationDTO> getOrganizationsByCountry(@RequestParam List<String> countriesIso) {
        return null;
    }

    @GetMapping("/projects")
    public List<UsageLevelProjectDTO> getAllProjects() {
        return null;
    }

    @GetMapping(value = "/projects", params = {"countriesIso", "organisationsId"})
    //Request parameters will be mapped to object: http://localhost:8080/forms/projects?countriesIso=ISR,RUS,US&organisationsId=1,2,3
    public List<UsageLevelProjectDTO> getProjects(@RequestParam List<String> countriesIso, @RequestParam List<Long> organisationsId) {
        return null;
    }

    /*@GetMapping("/projects")
    //Request parameters will be mapped to object: http://localhost:8080/forms/projects?countriesIso=ISR,RUS,US&organisationsId=1,2,3
    public List<UsageLevelProjectDTO> getProjects(SearchProjectDTO searchProjectDTO) {
        return null;
    }*/

    @GetMapping(value = "/users", params = {"countriesIso", "organisationsId", "projectsId"})
    public List<UsageLevelUserDTO> getAllUsers() {
        return null;
    }
    @GetMapping("/users")
    //http://localhost:8080/forms/users?countriesIso=ISR,RUS,US&organisationsId=1,2,3&projectsId=1,2,3
    public List<UsageLevelUserDTO> getUsers(@RequestParam List<String> countriesIso,
                                            @RequestParam List<Long> organisationsId,
                                            @RequestParam List<Long> projectsId)
    {
        return null;
    }

   /* @GetMapping("/users")
    //http://localhost:8080/forms/users?countriesIso=ISR,RUS,US&organisationsId=1,2,3&projectsId=1,2,3
    public List<UsageLevelUserDTO> getUsers(SearchUserDto searchUserDto) {
        return null;
    }*/

}
