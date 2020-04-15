package com.papaya.dynamicdatamanagement.data_model.template;

import java.util.List;

public enum FormType {
    PAYMENT_TEMPLATE,
    WORKER_ON_BOARDING,
    SUPPLEMENTARY_WORKER_INFORMATION,
    SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE,
    DYNAMIC,
    DYNAMIC_CREATION_TEMPLATE;

    public static List<FormType> getAllCreationTemplateTypes(){
        return List.of(SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE,DYNAMIC_CREATION_TEMPLATE);
    }
}
