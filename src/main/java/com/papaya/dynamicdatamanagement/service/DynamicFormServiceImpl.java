package com.papaya.dynamicdatamanagement.service;

import com.papaya.dynamicdatamanagement.data_model.SupplementaryWorkerInformation;
import com.papaya.dynamicdatamanagement.model.elements.main.FormType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
//TODO form type can be dynamic!!!
// 1.Should I create predefined object meta data table to store which field is required in static object or we will define that in Form template?
// (May be it will be required in some cases can be not required that's why it can't be mapped by annotations)?
// 2. Form type it should be enum but it can be dynamic form creation and then we can not define it in enum

//TODO Cases for form creation:
// 1.Form based on static object
//      a. getBuildingBlocksForSupplementaryWorkerInformationForm()
//          1. getCreationTemplateForSupplementaryWorkerInformationForm()
// 2.Form based on static object + custom inputs
// 3.Form creation template based on static object
//      a. getBuildingBlocksForCreationTemplateBasedOnSupplementaryWorkerInformation()
//          1. set form type creation template (SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE)
//      b. saveCreationTemplateForSupplementaryWorkerInformation()
//      c. updateCreationTemplateForSupplementaryWorkerInformation()
//      d. deleteCreationTemplateForSupplementaryWorkerInformation()
// 4.Form creation template based on static object + custom inputs
// 5.Dynamic form
// 6.Dynamic form creation template
public class DynamicFormServiceImpl implements DynamicFormService {
    /**
     * Predefined building blocks
     *  1. predefined required building blocks
     *  2. predefined optional building blocks
     *  3. custom optional building blocks
     * @param formType form type for which building blocks are requested
     */
    @Override
    public void getFormBuildingBlocks(FormType formType) {
        getSupplementaryWorkerInformationFormBuildingBlocks();
    }

    private void getSupplementaryWorkerInformationFormBuildingBlocks() {
        String firstNameLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.firstName);
        String lastNameLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.lastName);
        String primaryEmailLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.primaryEmail);
        String companyNameLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.companyName);
        String homeAddressLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.homeAddress);
        String bankNameLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.bankName);
        String ibanLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.iban);
        String swiftLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.swift);
        String bankAccountNumberLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.bankAccountNumber);
        String bankCodeLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.bankCode);
        String branchNameLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.branchName);
        String branchCodeLabel = getLabelFromFieldName(SupplementaryWorkerInformation.Fields.branchCode);
        //StringTextField.builder()
    }

    @Override
    public void getDynamicFormBuildingBlocks() {

    }

    @Override
    public void saveSupplementaryWorkerInformationForm() {

    }

    @Override
    public void saveDynamicForm() {

    }

    @Override
    public void updateForm() {

    }

    /**
     *
     * @param formType - form type which user has filled
     * @param userInputs - user input values (Map: key - label, value - user input)
     */

    public void saveFilledForm(FormType formType, Map<String, String> userInputs){}

    private String getLabelFromFieldName(String fieldName) {
        String label =  Arrays.stream(fieldName.split("(?=[A-Z])")).map(String::toLowerCase).collect(Collectors.joining(" "));
        return label.substring(0, 1).toUpperCase() + label.substring(1);
    }


}
