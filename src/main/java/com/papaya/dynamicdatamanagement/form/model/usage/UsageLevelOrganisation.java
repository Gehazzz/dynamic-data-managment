package com.papaya.dynamicdatamanagement.form.model.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsageLevelOrganisation {
    private long organisationId;
    private String organisationName;
}
