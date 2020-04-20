package com.papaya.dynamicdatamanagement.web.dto;

import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UsageLevelOrganisationDTO {
    private long organisationId;
    private String organisationName;
}
