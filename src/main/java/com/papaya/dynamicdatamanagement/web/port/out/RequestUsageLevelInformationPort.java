package com.papaya.dynamicdatamanagement.web.port.out;

import com.papaya.dynamicdatamanagement.web.dto.*;

import java.util.List;

public interface RequestUsageLevelInformationPort {
    List<OrganisationDTO> getAllOrganisations();

    List<OrganisationDTO> getAllOrganisationsByCountry(Long countryId);

    List<ProjectDTO> getAllProjects();

    List<ProjectDTO> getProjects(SearchProjectDTO searchProjectDTO);

    List<ProjectDTO> getAllProjectsByOrganisation(Long orgId);

    List<RoleDTO> getAllRoles();

    List<RoleDTO> getRoles(SearchRoleDto searchRoleDto);

    List<RoleDTO> getAllRolesByOrganisation(Long orgId);

    List<RoleDTO> getAllRolesByProject(Long projectId);

    List<CountryDTO> getAllCountries();

    List<CountryDTO> getAllCountriesByOrganisation(Long orgId);
}
