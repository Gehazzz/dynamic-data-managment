package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;

public interface SaveFilledFormPort {
    Form saveForm(Form form);
}
