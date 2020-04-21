package com.papaya.dynamicdatamanagement.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectDTO {
    private long projectId;
    private String projectName;
}
