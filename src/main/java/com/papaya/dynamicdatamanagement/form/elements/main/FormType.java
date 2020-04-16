package com.papaya.dynamicdatamanagement.form.elements.main;

import java.util.List;

public enum FormType {
    PAYMENT_TEMPLATE(Group.FORM_TEMPLATE),
    WORKER_ON_BOARDING(Group.FORM),
    SUPPLEMENTARY_WORKER_INFORMATION(Group.FORM),
    SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE(Group.FORM_TEMPLATE),
    SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE(Group.FORM_CREATION_TEMPLATE),
    DYNAMIC(Group.FORM),
    DYNAMIC_TEMPLATE(Group.FORM_TEMPLATE),
    DYNAMIC_CREATION_TEMPLATE(Group.FORM_CREATION_TEMPLATE);

    private Group group;

    FormType(Group group) {
        this.group = group;
    }

    public static List<FormType> getAllCreationTemplateTypes(){
        return List.of(SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE,DYNAMIC_CREATION_TEMPLATE);
    }

    public boolean isInGroup(Group group) {
        return this.group == group;
    }

    public enum Group {
        FORM,
        FORM_TEMPLATE,
        FORM_CREATION_TEMPLATE;
    }
}
