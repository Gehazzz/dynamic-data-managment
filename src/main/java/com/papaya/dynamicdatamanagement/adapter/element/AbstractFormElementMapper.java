package com.papaya.dynamicdatamanagement.adapter.element;

import com.papaya.dynamicdatamanagement.repository.model.template.AbstractFormElementTemplate;
import com.papaya.dynamicdatamanagement.form.model.elements.main.AbstractFormElement;

public interface AbstractFormElementMapper {

    AbstractFormElement mapToServiceEntity(AbstractFormElementTemplate abstractFormElementTemplate);
    AbstractFormElementTemplate mapToDataEntity(AbstractFormElement abstractFormElement);

}
