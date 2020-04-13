package com.papaya.dynamicdatamanagement.adapter.element;

import com.papaya.dynamicdatamanagement.data_model.template.AbstractFormElementTemplate;
import com.papaya.dynamicdatamanagement.model.elements.main.AbstractFormElement;

public interface AbstractFormElementMapper {

    AbstractFormElement mapToServiceEntity(AbstractFormElementTemplate abstractFormElementTemplate);
    AbstractFormElementTemplate mapToDataEntity(AbstractFormElement abstractFormElement);

}
