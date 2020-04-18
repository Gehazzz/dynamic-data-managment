package com.papaya.dynamicdatamanagement.form.elements.main;

public enum FormType {
    SUPPLEMENTARY_WORKER_INFORMATION(Group.FORM, Service.SUPPLEMENTARY_WORKER_INFORMATION),
    SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE(Group.FORM_TEMPLATE, Service.SUPPLEMENTARY_WORKER_INFORMATION),
    SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE(Group.FORM_CREATION_TEMPLATE, Service.SUPPLEMENTARY_WORKER_INFORMATION),
    DYNAMIC(Group.FORM, Service.DYNAMIC),
    DYNAMIC_TEMPLATE(FormType.Group.FORM_TEMPLATE, Service.DYNAMIC),
    DYNAMIC_CREATION_TEMPLATE(Group.FORM_CREATION_TEMPLATE, Service.DYNAMIC);

    private Group group;
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
    }
}
