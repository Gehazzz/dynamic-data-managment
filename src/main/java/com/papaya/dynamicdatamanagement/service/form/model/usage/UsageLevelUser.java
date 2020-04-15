package com.papaya.dynamicdatamanagement.service.form.model.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsageLevelUser {
    private long userId;
    private String userName;
}
