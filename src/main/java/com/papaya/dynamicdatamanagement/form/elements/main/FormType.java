package com.papaya.dynamicdatamanagement.form.elements.main;
//TODO add support for concrete type of dynamic form
public enum FormType {
    PAYMENT_TEMPLATE,
    WORKER_ON_BOARDING,
    SUPPLEMENTARY_WORKER_INFORMATION,
    DYNAMIC;

   /* private Group group;
    private Service service;

    FormType(Group group, Service service) {
        this.group = group;
        this.service = service;
    }

    public boolean isInGroup(Group group) {
        return this.group == group;
    }

    public Group getGroup() {
        return group;
    }

    public Service getService() {
        return service;
    }

    public enum Group {
        FORM,
        FORM_TEMPLATE,
        FORM_CREATION_TEMPLATE;
    }
    
    public enum Service{
        SUPPLEMENTARY_WORKER_INFORMATION,
        DYNAMIC;
    }*/
}
