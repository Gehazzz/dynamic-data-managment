package com.papaya.dynamicdatamanagement.service;

import com.papaya.dynamicdatamanagement.model.elements.main.FormType;

public interface DynamicFormService {
    void getFormBuildingBlocks(FormType formType);
    void getDynamicFormBuildingBlocks();
    void saveDynamicForm();
    void saveSupplementaryWorkerInformationForm();
    void updateForm();
}
