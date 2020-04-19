package com.papaya.dynamicdatamanagement.form.elements.main.not_relevant_enums;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;

public enum FormServiceType {
    SUPPLEMENTARY_WORKER_INFORMATION(FormType.SUPPLEMENTARY_WORKER_INFORMATION, null, null),
    DYNAMIC(FormType.DYNAMIC, null,null);

    private FormType form;
    private FormType formTemplate;
    private FormType formCreationTemplate;


    FormServiceType(FormType form, FormType formTemplate, FormType formCreationTemplate) {
        this.form = form;
        this.formTemplate = formTemplate;
        this.formCreationTemplate = formCreationTemplate;
    }

    public FormType getForm() {
        return form;
    }

    public FormType getFormTemplate() {
        return formTemplate;
    }

    public FormType getFormCreationTemplate() {
        return formCreationTemplate;
    }
}
