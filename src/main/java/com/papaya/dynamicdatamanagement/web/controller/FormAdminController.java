package com.papaya.dynamicdatamanagement.web.controller;

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
@RequestMapping("/api/v1/admin/forms")
//@RequestMapping("/api/v1/admin/form")
public class FormAdminController {
    /**
     * @return all forms, form templates, form creation templates
     */
    @GetMapping("/form")
    //@GetMapping("/forms")
    List<FormDTO> getAllForms() {
        return null;
    }

    /**
     * @param id form id
     * @return form by id, it can be form, form template or form creation template
     */
    @GetMapping("/form/{id}")
    FormDTO getForm(@PathVariable("id") Long id) {
        return null;
    }

    //@GetMapping
        //Can replace all search methods
    List<FormDTO> searchForms(AdminFormSearchDTO adminFormSearchDTO) {
        return null;
    }

    /**
     * @param formType DYNAMIC, SUPPLEMENTARY_WORKER_INFORMATION
     * @return all forms, form templates, form creation templates of provided type
     */
    @GetMapping(path = "/form", params = "formType")
    List<FormDTO> getForms(FormTypeDTO formType) {
        return null;
    }

    /**
     * @param label    specific form label
     * @param formType DYNAMIC, SUPPLEMENTARY_WORKER_INFORMATION
     * @return all forms, form templates, form creation templates of provided type and has provided label
     * <p>
     * Can be useful once we want request specific form of dynamic type
     */

    @GetMapping(path = "/form", params = {"label", "formType"})
    List<FormDTO> getForms(String label, FormTypeDTO formType) {
        return null;
    }

    /**
     * @param formSubType FORM, FORM_TEMPLATE, FORM_CREATION_TEMPLATE
     * @return all forms of provided sub type
     */
    @GetMapping(path = "/form", params = "formSubType")
    List<FormDTO> getForms(@RequestParam FormSubTypeDTO formSubType) {
        return null;
    }

    @GetMapping(path = "/form", params = {"label", "formSubType"})
    List<FormDTO> getForms(@RequestParam String label, @RequestParam FormSubTypeDTO formSubType) {
        return null;
    }

    @GetMapping(path = "/form", params = {"formSubType", "usageLevel"})
    List<FormDTO> getForms(@RequestParam FormSubTypeDTO formSubType, @RequestParam UsageLevelDTO usageLevel) {
        return null;
    }

    @GetMapping(path = "/form", params = {"label", "formSubType", "usageLevel"})
    List<FormDTO> getForms(@RequestParam String label, @RequestParam FormSubTypeDTO formSubType, @RequestParam UsageLevelDTO usageLevel) {
        return null;
    }

    @GetMapping(path = "/form", params = {"formSubType", "usageLevels"})
    List<FormDTO> getForms(@RequestParam FormSubTypeDTO formSubType, @RequestParam List<UsageLevelDTO> usageLevels) {
        return null;
    }

    @GetMapping(path = "/form", params = {"formType", "formSubType"})
    List<FormDTO> getForms(@RequestParam FormTypeDTO formType, @RequestParam FormSubTypeDTO formSubType) {
        return null;
    }

    @GetMapping(path = "/form", params = {"formType", "formSubType", "usageLevel"})
    List<FormDTO> getForms(@RequestParam FormTypeDTO formType, @RequestParam FormSubTypeDTO formSubType, @RequestParam UsageLevelDTO usageLevel) {
        return null;
    }

    @GetMapping(path = "/form", params = {"formType", "formSubType", "usageLevels"})
    List<FormDTO> getForms(@RequestParam FormTypeDTO formType, @RequestParam FormSubTypeDTO formSubType, @RequestParam List<UsageLevelDTO> usageLevels) {
        return null;
    }

    @GetMapping("/form/{id}/available-elements")
    List<FormElementDTO> getFormAvailableElements(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    FormDTO saveForm(@RequestBody FormDTO form) {
        return null;
    }

    @PutMapping("/form/{id}")
    @ResponseStatus(HttpStatus.OK)
    FormDTO updateForm(@PathVariable("id") Long id, @RequestBody FormDTO formDTO) {
        return null;
    }

    @PutMapping("/form/{id}/usage-level")
    @ResponseStatus(HttpStatus.OK)
    FormDTO assignFormUsageLevel(@PathVariable("id") Long id, @RequestBody List<UsageLevelDTO> usageLevel) {
        return null;
    }

    @DeleteMapping("/form/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteForm(@PathVariable("id") Long id) {
    }




    /**
     * @return all filled forms
     */
    @GetMapping("/filled")
    //@GetMapping("/filled-forms")
    List<FormDTO> getAllFilledForms() {
        return null;
    }

    @GetMapping("/filled/search")
        ///api/v1/org/{orgId}/project/{projectId}/customer/forms/filled/search?status=submitted&userName=John&formType=dynamic&label=worker_expenses
    List<FormDTO> getSubmittedForms(AdminFilledFormSearchDTO customerFormSearch) {
        return null;
    }

    /**
     * @param id filled form id
     * @return it will be form with subtype form and with bounded data
     */
    @GetMapping("/filled/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/filled")
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm){return null;}

    /**
     * admin will update filled form: filled data can be changed, status can be changed
     * @param id filled form id to be managed
     * @param filledFormWithStatus filled form
     * @return approved filled form id
     */
    @PutMapping("/filled/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable Long id, @RequestBody FilledFormWithStatusDTO filledFormWithStatus){return null;}

    @DeleteMapping(value = "/filled/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteFilledForm(@PathVariable("id") Long id) {
    }
}
