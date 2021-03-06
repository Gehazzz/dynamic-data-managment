package com.papaya.dynamicdatamanagement.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class SearchProjectDTO {
    private List<String> countriesIso;
    private List<Long> organisationsId;
}
