package com.papaya.dynamicdatamanagement.service.form.model.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UsageLevelProject {
    private long projectId;
    private String projectName;
    List<UsageLevelUser> usageLevelUsers;
}
