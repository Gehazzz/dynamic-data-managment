package com.papaya.dynamicdatamanagement.service.form;

import com.papaya.dynamicdatamanagement.service.form.model.elements.main.FormType;

public interface DynamicFormService {
    void getFormBuildingBlocks(FormType formType);
    void getDynamicFormBuildingBlocks();
    void saveDynamicForm();
    void saveSupplementaryWorkerInformationForm();
    void updateForm();
}
