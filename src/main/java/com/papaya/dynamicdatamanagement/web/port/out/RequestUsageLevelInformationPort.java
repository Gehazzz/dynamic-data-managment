package com.papaya.dynamicdatamanagement.web.port.out;

import com.papaya.dynamicdatamanagement.web.dto.UsageLevelCountryDTO;
import com.papaya.dynamicdatamanagement.web.dto.UsageLevelOrganisationDTO;
import com.papaya.dynamicdatamanagement.web.dto.UsageLevelUserDTO;

import java.util.List;

public interface RequestUsageLevelInformationPort {
    List<UsageLevelOrganisationDTO> getAllOrganisations();

    List<UsageLevelOrganisationDTO> getAllOrganisationsByCountry(Long countryId);

    List<UsageLevelProjectDTO> getAllProjects();

    List<UsageLevelProjectDTO> getAllProjectsByOrganisation(Long orgId);

    List<UsageLevelUserDTO> getAllUsers();

    List<UsageLevelUserDTO> getAllUsersByOrganisation(Long orgId);

    List<UsageLevelUserDTO> getAllUsersByProject(Long projectId);

    List<UsageLevelCountryDTO> getAllCountries();

    List<UsageLevelCountryDTO> getAllCountriesByOrganisation(Long orgId);
}
