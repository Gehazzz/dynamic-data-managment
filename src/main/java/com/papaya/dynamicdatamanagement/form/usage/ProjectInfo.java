package com.papaya.dynamicdatamanagement.form.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProjectInfo {
    private long projectId;
    private String projectName;

}
