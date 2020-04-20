package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.*;
import com.papaya.dynamicdatamanagement.form.elements.main.*;
import com.papaya.dynamicdatamanagement.form.model.SupplementaryWorker;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService2;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.service.port.out.SaveFilledFormPort;
import com.papaya.dynamicdatamanagement.form.service.port.out.SaveFormPort;
import com.papaya.dynamicdatamanagement.form.validation.PatternValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SupplementaryWorkerInformationFormService2 implements FormService2 {

    @Autowired
    private QueryFormPort queryFormPort;
    @Autowired
    private SaveFormPort saveFormPort;
    @Autowired
    private SaveFilledFormPort saveFilledFormPort;

    @Override
    public Form getDefaultTemplate() {
        List<AbstractFormElement> elements = new ArrayList<>();
        Section section = Section.builder().formElements(elements).visible(true).build();
        Form form = Form.builder().mainSection(section).formType(FormType.SUPPLEMENTARY_WORKER_INFORMATION).formSubType(FormSubType.CREATION_TEMPLATE).build();

        String firstNameLabel = getLabelFromFieldName(SupplementaryWorker.Fields.firstName);
        StringTextField firstNameInputField = StringTextField.innerBuilder()
                .index(0)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(firstNameLabel)
                .hint(firstNameLabel)
                .required(true)
                .requiredMessage(firstNameLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + firstNameLabel)
                .build();
        elements.add(firstNameInputField);

        String lastNameLabel = getLabelFromFieldName(SupplementaryWorker.Fields.lastName);
        StringTextField lastNameInputField = StringTextField.innerBuilder()
                .index(1)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(lastNameLabel)
                .hint(lastNameLabel)
                .required(true)
                .requiredMessage(lastNameLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + lastNameLabel)
                .build();
        elements.add(lastNameInputField);

        String primaryEmailLabel = getLabelFromFieldName(SupplementaryWorker.Fields.primaryEmail);
        PatternValidator patternValidator = PatternValidator.builder()
                .pattern(Pattern.compile("^(.+)@(.+)$"))
                .message("Invalid email address")
                .build();
        StringTextField primaryEmailInputField = StringTextField.innerBuilder()
                .index(2)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(primaryEmailLabel)
                .hint(primaryEmailLabel)
                .required(true)
                .requiredMessage(primaryEmailLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + primaryEmailLabel)
                .fieldValidators(List.of(patternValidator))
                .build();
        elements.add(primaryEmailInputField);

        String companyNameLabel = getLabelFromFieldName(SupplementaryWorker.Fields.companyName);
        StringTextField companyNameInputField = StringTextField.innerBuilder()
                .index(3)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(companyNameLabel)
                .hint(companyNameLabel)
                .required(true)
                .requiredMessage(companyNameLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + companyNameLabel)
                .build();
        elements.add(companyNameInputField);

        String homeAddressLabel = getLabelFromFieldName(SupplementaryWorker.Fields.homeAddress);
        StringTextField homeAddressInputField = StringTextField.innerBuilder()
                .index(4)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(homeAddressLabel)
                .hint(homeAddressLabel)
                .required(true)
                .requiredMessage(homeAddressLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + homeAddressLabel)
                .build();
        elements.add(homeAddressInputField);

        String bankNameLabel = getLabelFromFieldName(SupplementaryWorker.Fields.bankName);
        StringTextField bankNameInputField = StringTextField.innerBuilder()
                .index(5)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(bankNameLabel)
                .hint(bankNameLabel)
                .required(true)
                .requiredMessage(bankNameLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + bankNameLabel)
                .build();
        elements.add(bankNameInputField);

        String ibanLabel = getLabelFromFieldName(SupplementaryWorker.Fields.iban);
        StringTextField ibanInputField = StringTextField.innerBuilder()
                .index(6)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(ibanLabel)
                .hint(ibanLabel)
                .required(true)
                .requiredMessage(ibanLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + ibanLabel)
                .build();
        elements.add(ibanInputField);

        String swiftLabel = getLabelFromFieldName(SupplementaryWorker.Fields.swift);
        StringTextField swiftInputField = StringTextField.innerBuilder()
                .index(7)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(swiftLabel)
                .hint(swiftLabel)
                .required(true)
                .requiredMessage(swiftLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + swiftLabel)
                .build();
        elements.add(swiftInputField);

        String bankAccountNumberLabel = getLabelFromFieldName(SupplementaryWorker.Fields.bankAccountNumber);
        StringTextField bankAccountInputField = StringTextField.innerBuilder()
                .index(8)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(bankAccountNumberLabel)
                .hint(bankAccountNumberLabel)
                .required(true)
                .requiredMessage(bankAccountNumberLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + bankAccountNumberLabel)
                .build();
        elements.add(bankAccountInputField);

        String bankCodeLabel = getLabelFromFieldName(SupplementaryWorker.Fields.bankCode);
        StringTextField bankCodeInputField = StringTextField.innerBuilder()
                .index(9)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(bankCodeLabel)
                .hint(bankCodeLabel)
                .required(true)
                .requiredMessage(bankCodeLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + bankCodeLabel)
                .build();
        elements.add(bankCodeInputField);

        String branchNameLabel = getLabelFromFieldName(SupplementaryWorker.Fields.branchName);
        StringTextField branchNameInputField = StringTextField.innerBuilder()
                .index(10)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(branchNameLabel)
                .hint(branchNameLabel)
                .required(true)
                .requiredMessage(branchNameLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + branchNameLabel)
                .build();
        elements.add(branchNameInputField);

        String branchCodeLabel = getLabelFromFieldName(SupplementaryWorker.Fields.branchCode);
        StringTextField branchCodeInputField = StringTextField.innerBuilder()
                .index(11)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(true)
                .label(branchCodeLabel)
                .hint(branchCodeLabel)
                .required(true)
                .requiredMessage(branchCodeLabel + "is required")
                .enabled(true)
                .placeholder("Type here your " + branchCodeLabel)
                .build();
        elements.add(branchCodeInputField);

        return form;
    }

    private String getLabelFromFieldName(String fieldName) {
        String label = Arrays.stream(fieldName.split("(?=[A-Z])")).map(String::toLowerCase).collect(Collectors.joining(" "));
        return label.substring(0, 1).toUpperCase() + label.substring(1);
    }

    @Override
    public Form saveTemplate(Form form) {
        return saveFormPort.saveForm(form);
    }

    @Override
    public Form saveFilledForm(Form form, Map<String, String> userInputs) {
        //Bind values
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
        return FormType.SUPPLEMENTARY_WORKER_INFORMATION;
    }
}
