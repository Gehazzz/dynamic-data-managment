package com.papaya.dynamicdatamanagement.form.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UsageLevelCountry {
    private long countryId;
    private String countryName;
}
