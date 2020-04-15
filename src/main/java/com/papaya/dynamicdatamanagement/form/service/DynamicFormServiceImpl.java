package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.repository.model.SupplementaryWorkerInformation;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
//TODO form type can be dynamic!!!
// 1.Should I create predefined object meta data table to store which field is required in static object or we will define that in Form template?
// (May be it will be required in some cases can be not required that's why it can't be mapped by annotations)?
// 2. Form type it should be enum but it can be dynamic form creation and then we can not define it in enum
// 3. Form type how to implement?

//TODO Requesting defined form:
// 1. Long formId, FormType formType

//TODO Filling form: ----------------------------------------------------------------------------------------------------------------------------------------------------------
// 1. choose form to fill
//      a. getAllFormsByOrganisationIdAndProjectIdAndUserId() or getAllFormsByOrganisationIdAndProjectIdAndUserIdAndFormTypeNotIn() - not in this list of enums with creation types;
//      b. getAllFormsByOrganisationIdAndProjectId() - not in this list of enums with creation types;
//      c. getAllFormsByProjectIdAndUserId() - not in this list of enums with creation types;
//      d. getAllFormsByOrganisationId() - not in this list of enums with creation types;
//      e. getAllFormsByProjectId() - not in this list of enums with creation types;
//      f. getAllFormsByUserId() - not in this list of enums with creation types;
// 3. get form to fill
//      a. getFormById()
//      b. getFormBy_Label_And_Type_And_OrganisationId_And_ProjectId_And_UserId()
//      c. getFormBy_Label_And_Type_And_OrganisationId_And_ProjectId()
//      d. getFormBy_Label_And_Type_And_OrganisationId()
//      e. getFormBy_Label_And_ProjectId()
// 2. post filled form -> Long formId, FormType formType, Map<String, String> userInputs

//TODO Get all form types: ---------------------------------------------------------------------------------------------------------------------------------------------------
// 1. getAllFormTypes()
// 2. getAllFormTypesByOwner(FormOwner formOwner)
//      a. FormOwner -> formType(String- defined by user), orgId, project, userId, userGroupId, projectGroupId, OrgGroupId
//      b. FormOwner data layer -> formType,

//TODO Form creation: NOT RELEVANT---------------------------------------------------------------------------------------------------------------------------------------------
// 1. choose form creation template to create form
// 2. create form creation template
//      a.Form based on static object
//          1. getBuildingBlocksForSupplementaryWorkerInformationForm()
//              a. if exist -> getCreationTemplateForSupplementaryWorkerInformationForm()
//                  else -> createDefaultCreationTemplate()
//      b.Form based on static object + custom inputs
//          1. getBuildingBlocksForSupplementaryWorkerInformationForm()
//              a. if exist -> getCreationTemplateForSupplementaryWorkerInformationForm()
//                  else -> createDefaultCreationTemplate() without custom inputs
//      c.Form creation template based on static object
//          1. getBuildingBlocksForCreationTemplateBasedOnSupplementaryWorkerInformation()
//              a. set form type creation template (SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE)
//          2. saveCreationTemplateForSupplementaryWorkerInformation()
//          3. updateCreationTemplateForSupplementaryWorkerInformation()
//          4. deleteCreationTemplateForSupplementaryWorkerInformation()
//      d.Form creation template based on static object + custom inputs
//          1. The same as at point c.
//      e.Dynamic form
//          1. getBuildingBlocksForDynamicForm(DynamicFormType type)
//              a. if exist -> getCreationTemplateForDynamicForm(DynamicFormType type)
//                  else -> createDefaultCreationTemplate(). create default will return empty template
//      f.Dynamic form creation template
//      g.Additional methods
//          1. getAllInputs() - will return a list of all inputs (textInput, checkbox, checkbox group, drop down etc....)


//TODO for the following logic label can be replaced with some uniq id that will be created by user (requires deep thinking)---------------------------------------------------

//TODO Form creation template creation: ---------------------------------------------------------------------------------------------------------------------------------------
// 1. choosing form type and form level (Organisation, project, user, country) for creation template, if user chose's dynamic creation type, he should provide form label
//      a. getAllAvailableFormCreationTypes()
//      b. getAllOrganisations()
//      c. getAllProjects()
//      d. getAllProjectsByOrganisation()
//      e. getAllUsers()
//      f. getAllUsersByOrganisation()
//      g. getAllUsersByProject()
//      h. getAllCountries()
// 2. get default creation template for selected type
//      a.Form based on static object
//          1. Check if creation template for selected type exist
//              a. getFormBy_Type(creationType)
//              b. getFormBy_Type_And_OrganisationId(creationType, organisationId)
//              c. getFormBy_Type_And_OrganisationId_And_ProjectId(creationType, organisationId, projectId)
//              d. getFormBy_Type_And_OrganisationId_And_ProjectId_And_Country(creationType, orgId, projectId)getFormBy_Type_And_OrganisationId_And_ProjectId_And_Country(creationType, orgId, projectId)
//              e. getFormBy_Type_And_CountryId(creationType, countryId)
//              f. getFormBy_Type_And_userId(creationType, userId)
//          2. if exist
//              a. return this creation template for selected type + list of all possible elements
//          3. else
//              a. build and return default for selected type  + list of all possible elements
//      b. Dynamic form creation template
//          1. Check if creation template for selected type exist
//              a. getFormBy_Type_And_Label...(DYNAMIC_CREATION_TEMPLATE, label, ...)
//              b. all methods are same as for creation template for static object with addition label parameter
//          2. if exist
//              a. return this creation template for dynamic type  + list of all possible elements
//          3. else
//              a. build and return default for dynamic type (it will be list of all possible elements)
// 3. save creation template
// 4. update creation template
// 5. delete creation template

//TODO Form template creation:
// 1. choosing form type and form level, if user chose's dynamic creation type, he should provide form label
//      a. getAllAvailableFormTemplatesTypes()
//      b. getAllOrganisations()
//      c. getAllProjects()
//      d. getAllProjectsByOrganisation()
//      e. getAllUsers()
//      f. getAllUsersByOrganisation()
//      g. getAllUsersByProject()
//      h. getAllCountries()
// 2. get default template for selected type
//      a.Form based on static object
//          1. Check if form template for selected type exist
//              a. getFormBy_Type(type)
//              b. getFormBy_Type_And_OrganisationId(type, organisationId)
//              c. getFormBy_Type_And_OrganisationId_And_ProjectId(type, organisationId, projectId)
//              d. getFormBy_Type_And_OrganisationId_And_ProjectId_And_Country(type, orgId, projectId)getFormBy_Type_And_OrganisationId_And_ProjectId_And_Country(creationType, orgId, projectId)
//              e. getFormBy_Type_And_CountryId(type, countryId)
//              f. getFormBy_Type_And_userId(type, userId)
//          2. if exist
//              a. return this creation template for selected type + list of all possible elements
//          3. else
//              a. build and return default for selected type  + list of all possible elements
//      b. Dynamic form template
//          1. Check if form template for selected type exist
//              a. getFormBy_Type_And_Label...(DYNAMIC, label, ...)
//              b. all methods are same as for form template for static object with addition label parameter
//          2. if exist
//              a. return this form template for dynamic type  + list of all possible elements
//          3. else
//              a. build and return default for dynamic type (it will be list of all possible elements)
// 3. save form template
// 4. update form template
// 5. delete form template
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
