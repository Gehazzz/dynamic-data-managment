package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.*;
import com.papaya.dynamicdatamanagement.form.elements.main.*;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService2;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.service.port.out.SaveFilledFormPort;
import com.papaya.dynamicdatamanagement.form.service.port.out.SaveFormPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class DynamicFormService2 implements FormService2 {
    @Autowired
    private QueryFormPort queryFormPort;
    @Autowired
    private SaveFormPort saveFormPort;
    @Autowired
    private SaveFilledFormPort saveFilledFormPort;

    @Override
    public Form getDefaultTemplate() {
        Section section = Section.builder().visible(true).build();
        return Form.builder().mainSection(section).formType(FormType.DYNAMIC).formSubType(FormSubType.CREATION_TEMPLATE).build();
    }

    @Override
    public Form saveTemplate(Form form) {
        return saveFormPort.saveForm(form);
    }

    @Override
    public Form saveFilledForm(Form form, Map<String, String> userInputs) {
        //TODO bind values
        return saveFilledFormPort.saveForm(form);
    }

    @Override
    public List<AbstractFormElement> getAvailableElements(Form form) {
        return List.of(Section.builder().build(),
                Text.builder().build(),
                StringTextField.builder().build(),
                IntegerTextField.builder().build(),
                DoubleTextField.builder().build(),
                TextArea.builder().build(),
                DateTimeInput.builder().build(),
                Checkbox.builder().build(),
                CheckboxGroup.builder().build(),
                RadioGroup.builder().build(),
                DropDown.builder().build(),
                FileInput.builder().build()
        );
    }

    @Override
    public FormType getType() {
        return FormType.DYNAMIC;
    }
}
