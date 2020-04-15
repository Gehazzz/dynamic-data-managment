package com.papaya.dynamicdatamanagement.service.form.model.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UsageLevelOrganisation {
    private long organisationId;
    private String organisationName;
}
