package com.papaya.dynamicdatamanagement.form.elements.main.not_relevant_enums;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;

public enum FormServiceType {
    SUPPLEMENTARY_WORKER_INFORMATION(FormType.SUPPLEMENTARY_WORKER_INFORMATION, FormType.SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE, FormType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE),
    DYNAMIC(FormType.DYNAMIC, FormType.DYNAMIC_TEMPLATE,FormType.DYNAMIC_CREATION_TEMPLATE);

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
