package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.model.elements.main.FormType;

public interface DynamicFormService {
    void getFormBuildingBlocks(FormType formType);
    void getDynamicFormBuildingBlocks();
    void saveDynamicForm();
    void saveSupplementaryWorkerInformationForm();
    void updateForm();
}