package com.papaya.dynamicdatamanagement.form.elements.main.not_relevant_enums;

import java.util.List;
import java.util.Map;

public enum Type {
    PAYMENT_TEMPLATE(Group.FORM_TEMPLATE),
    WORKER_ON_BOARDING(Group.FORM),
    SUPPLEMENTARY_WORKER_INFORMATION(Group.FORM),
    SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE(Group.FORM_TEMPLATE),
    SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE(Group.FORM_CREATION_TEMPLATE),
    DYNAMIC(Group.FORM),
    DYNAMIC_TEMPLATE(Group.FORM_TEMPLATE),
    DYNAMIC_CREATION_TEMPLATE(Group.FORM_CREATION_TEMPLATE);

    private Group group;

    public static final Map<Group, Type> Types = Map.of(
            Group.FORM, SUPPLEMENTARY_WORKER_INFORMATION,
            Group.FORM_TEMPLATE, SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE,
            Group.FORM_CREATION_TEMPLATE, SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE
    );

    Type(Group group) {
        this.group = group;
    }

    public static List<Type> getAllCreationTemplateTypes(){
        return List.of(SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE,DYNAMIC_CREATION_TEMPLATE);
    }

/*    public boolean equalsAndInFormGroup(EnumSet<Type> TypeEnumSet){
        return TypeEnumSet.contains(this) && this.isInGroup(Group.FORM);
    }

    public boolean equalsAndInFormTemplateGroup(EnumSet<Type> TypeEnumSet){
        return TypeEnumSet.contains(this) && this.isInGroup(Group.FORM_TEMPLATE);
    }

    public boolean equalsAndInFormCreationTemplateGroup(EnumSet<Type> TypeEnumSet){
        return TypeEnumSet.contains(this) && this.isInGroup(Group.FORM_CREATION_TEMPLATE);
    }*/

    public boolean isInGroup(Group group) {
        return this.group == group;
    }

    public enum Group {
        FORM,
        FORM_TEMPLATE,
        FORM_CREATION_TEMPLATE;
    }
}
