package com.papaya.dynamicdatamanagement.form.model.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsageLevelProject {
    private long projectId;
    private String projectName;
}
