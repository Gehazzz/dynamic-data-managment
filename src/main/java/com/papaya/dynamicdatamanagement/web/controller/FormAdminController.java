package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO:
// 1. add paging
// 2. optional search redesign
// 3. validate list of usage levels on creation and update
@Slf4j
@RestController
@RequestMapping("/api/admin/forms")
public class FormAdminController {
    /**
     *
     * @return all forms, form templates, form creation templates
     */
    @GetMapping
    List<FormDTO> getAllForms(){return null;}

    /**
     *
     * @param id form id
     * @return form by id, it can be form, form template or form creation template
     */
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}

    @GetMapping
    //Can replace all search methods
    List<FormDTO> searchForms(SearchFormDTO searchFormDTO){return null;}

    /**
     *
     * @param formType DYNAMIC, SUPPLEMENTARY_WORKER_INFORMATION
     * @return all forms, form templates, form creation templates of provided type
     */
    @GetMapping(params = "formType")
    List<FormDTO> getForms(FormTypeDTO formType){return null;}

    /**
     *
     * @param label specific form label
     * @param formType DYNAMIC, SUPPLEMENTARY_WORKER_INFORMATION
     * @return all forms, form templates, form creation templates of provided type and has provided label
     *
     * Can be useful once we want request specific form of dynamic type
     */

    @GetMapping(params = {"label", "formType"})
    List<FormDTO> getForms(String label, FormTypeDTO formType){return null;}

    /**
     *
     * @param formSubType FORM, FORM_TEMPLATE, FORM_CREATION_TEMPLATE
     * @return all forms of provided sub type
     */
    @GetMapping(params = "formSubType")
    List<FormDTO> getForms(@RequestParam FormSubTypeDTO formSubType){return null;}

    @GetMapping(params = {"label", "formSubType"})
    List<FormDTO> getForms(@RequestParam String label, @RequestParam FormSubTypeDTO formSubType){return null;}

    @GetMapping(params = {"formSubType", "usageLevel"})
    List<FormDTO> getForms(@RequestParam FormSubTypeDTO formSubType, @RequestParam UsageLevelDTO usageLevel){return null;}

    @GetMapping(params = {"label", "formSubType", "usageLevel"})
    List<FormDTO> getForms(@RequestParam String label, @RequestParam FormSubTypeDTO formSubType, @RequestParam UsageLevelDTO usageLevel){return null;}

    @GetMapping(params = {"formSubType", "usageLevels"})
    List<FormDTO> getForms(@RequestParam FormSubTypeDTO formSubType, @RequestParam List<UsageLevelDTO> usageLevels){return null;}

    @GetMapping(params = {"formType", "formSubType"})
    List<FormDTO> getForms(@RequestParam FormTypeDTO formType, @RequestParam FormSubTypeDTO formSubType){return null;}

    @GetMapping(params = {"formType", "formSubType", "usageLevel"})
    List<FormDTO> getForms(@RequestParam FormTypeDTO formType, @RequestParam FormSubTypeDTO formSubType, @RequestParam UsageLevelDTO usageLevel){return null;}

    @GetMapping(params = {"formType", "formSubType", "usageLevels"})
    List<FormDTO> getForms(@RequestParam FormTypeDTO formType, @RequestParam FormSubTypeDTO formSubType, @RequestParam List<UsageLevelDTO> usageLevels){return null;}

    @GetMapping("/{id}/available-elements")
    List<FormElementDTO> getFormAvailableElements(@PathVariable("id") Long id){return null;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    FormDTO saveForm(@RequestBody FormDTO form){return null;}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FormDTO updateForm(@PathVariable( "id" ) Long id, @RequestBody FormDTO formDTO){return null;}

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteForm(@PathVariable( "id" ) Long id){}

    @PutMapping("/{id}/assign-usage-level")
    @ResponseStatus(HttpStatus.OK)
    FormDTO assignFormUsageLevel(@PathVariable( "id" ) Long id, @RequestBody List<UsageLevelDTO> usageLevel){return null;}
}
