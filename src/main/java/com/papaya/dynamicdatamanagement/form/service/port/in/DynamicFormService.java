package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.List;

public interface DynamicFormService {
    List<FormType> getAllFormTypes();
    List<FormType> getAllFormTypesByUsageLevel(UsageLevel usageLevel);
    void getFormBuildingBlocks(FormType formType);
    void getDynamicFormBuildingBlocks();
    void saveDynamicForm();
    void saveSupplementaryWorkerInformationForm();
    void updateForm();
}
