package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin/usage-level")
public class UsageLevelAdminController {
    @GetMapping("/countries")
    public List<CountryDTO> getAllCountries() {
        return null;
    }

    /**
     * http://localhost:8080/forms/countries?organisationIds=1,2,3
     *
     * @param organisationsId
     * @return
     */
    @GetMapping(value = "/countries", params = "organisationsId")
    public List<CountryDTO> getCountriesByOrganizations(@RequestParam List<Long> organisationsId) {
        return null;
    }

    @GetMapping("/organisations")
    public List<OrganisationDTO> getAllOrganizations() {
        return null;
    }

    /**
     * @param countriesIso
     * @return
     */
    @GetMapping(value = "/organisations", params = "countriesIso")
    public List<OrganisationDTO> getOrganizationsByCountry(@RequestParam List<String> countriesIso) {
        return null;
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getAllProjects() {
        return null;
    }

    @GetMapping(value = "/projects", params = {"countriesIso", "organisationsId"})
    //Request parameters will be mapped to object: http://localhost:8080/forms/projects?countriesIso=ISR,RUS,US&organisationsId=1,2,3
    public List<ProjectDTO> getProjects(@RequestParam List<String> countriesIso, @RequestParam List<Long> organisationsId) {
        return null;
    }

    /*@GetMapping("/projects")
    //Request parameters will be mapped to object: http://localhost:8080/forms/projects?countriesIso=ISR,RUS,US&organisationsId=1,2,3
    public List<UsageLevelProjectDTO> getProjects(SearchProjectDTO searchProjectDTO) {
        return null;
    }*/

    @GetMapping(value = "/roles", params = "searchRoles")
    //http://localhost:8080/forms/usage-level/users?searchRoles={countryIso: 'ISR', organisationId: 1,  projectId: 1},{countryIso: 'FR', organisationId: 2,  projectId: 4}
    public List<RoleDTO> getRoles(@RequestParam List<SearchRoleDto> searchRoles) {
        return null;
    }

    @GetMapping(value = "/roles", params = "searchRole")
    //http://localhost:8080/forms/usage-level/users?searchRole={countryIso: 'ISR', organisationId: 1,  projectId: 1}
    public List<RoleDTO> getRole(@RequestParam SearchRoleDto searchRole) {
        return null;
    }



//    @GetMapping("/users", params = {"countriesIso", "organisationsId", "projectsId"})
//    //http://localhost:8080/forms/users?countriesIso=ISR,RUS,US&organisationsId=1,2,3&projectsId=1,2,3
//    public List<RoleDTO> getUsers(@RequestParam List<String> countriesIso,
//                                  @RequestParam List<Long> organisationsId,
//                                  @RequestParam List<Long> projectsId)
//    {
//        return null;
//    }

   /* @GetMapping("/users")
    //http://localhost:8080/forms/users?countriesIso=ISR,RUS,US&organisationsId=1,2,3&projectsId=1,2,3
    public List<UsageLevelUserDTO> getUsers(SearchUserDto searchUserDto) {
        return null;
    }*/

}
