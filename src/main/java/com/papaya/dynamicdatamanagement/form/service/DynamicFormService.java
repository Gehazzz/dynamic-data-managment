package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.*;
import com.papaya.dynamicdatamanagement.form.elements.main.*;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService.*;
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
//          1. getBuildingBlocksForSupplementaryWorkerForm()
//              a. if exist -> getCreationTemplateForSupplementaryWorkerForm()
//                  else -> createDefaultCreationTemplate()
//      b.Form based on static object + custom inputs
//          1. getBuildingBlocksForSupplementaryWorkerForm()
//              a. if exist -> getCreationTemplateForSupplementaryWorkerForm()
//                  else -> createDefaultCreationTemplate() without custom inputs
//      c.Form creation template based on static object
//          1. getBuildingBlocksForCreationTemplateBasedOnSupplementaryWorker()
//              a. set form type creation template (SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE)
//          2. saveCreationTemplateForSupplementaryWorker()
//          3. updateCreationTemplateForSupplementaryWorker()
//          4. deleteCreationTemplateForSupplementaryWorker()
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
@Service
public class DynamicFormService implements FormService {
    @Autowired
    private QueryFormPort queryFormPort;

    @Override
    public List<Template> getFormCreationTemplates(FormQuery formQuery) {
        List<Form> creationTemplates = queryFormPort.getAllForms(this.getType(), FormSubType.CREATION_TEMPLATE, formQuery.getUsageLevel(), formQuery.getLabel());
        return creationTemplates.isEmpty() ? List.of(getDefaultDynamicFormCreationTemplate()) : creationTemplates.stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public FormType getType() {
        return FormType.DYNAMIC;
    }

    private Template getDefaultDynamicFormCreationTemplate() {
        List<AbstractFormElement> availableElements = getAvailableElements();
        Section section = Section.builder().visible(true).build();
        Form form = Form.builder().mainSection(section).formType(FormType.DYNAMIC).formSubType(FormSubType.CREATION_TEMPLATE).build();
        return Template.builder()
                .form(form)
                .availableElements(availableElements)
                .build();
    }

    private List<AbstractFormElement> getAvailableElements() {
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

    /**
     * @param formType   - form type which user has filled
     * @param userInputs - user input values (Map: key - label, value - user input)
     */

    public void saveFilledForm(FormType formType, Map<String, String> userInputs) {
    }
}
