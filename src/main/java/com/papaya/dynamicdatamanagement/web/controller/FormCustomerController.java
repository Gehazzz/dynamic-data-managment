package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer/org/{orgId}/project/{projectId}/forms")
//api/v2/org/{orgId}/project/{projectId}/
//TODO replace filled with submitted
public class FormCustomerController {

    /**
     * should return all forms for customer usage level
     */
    @GetMapping("/form")
    List<FormDTO> getForms() {
        return null;
    }

    @GetMapping("form/search")
    List<FormDTO> searchForms(CustomerFormSearchDTO customerFormSearch) {
        return null;
    }

    /**
     * should return form by id for customer usage level
     * @param id
     * @return
     */
    @GetMapping("/form/{id}")
    FormDTO getForm(@PathVariable("id") Long id) {
        return null;
    }








    @GetMapping("/filled")
    List<FormPreviewDTO> getFilledForms() {
        return null;
    }

    /**
     *
     * @param customerFormSearch
     * @return filled by users forms from customer usage level
     */

    @GetMapping("/filled/search")
    ///api/v1/org/{orgId}/project/{projectId}/customer/forms/search?status=submitted&userName=John&formType=dynamic&label=worker_expenses
    List<FormDTO> getSubmittedForms(CustomerFilledFormSearchDTO customerFormSearch) {
        return null;
    }



    @GetMapping("/filled/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id) {
        return null;
    }

    /*@GetMapping("/submitted/{id}")
    FormDTO getSubmittedForm(@PathVariable("id") Long id) {
        return null;
    }*/

    @PostMapping("/filled")
    @ResponseStatus(HttpStatus.CREATED)
    Long saveFilledForm(@RequestBody FilledFormDTO filledForm) {
        return null;
    }

    @PutMapping("/filled/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable("id") Long filledFormId, @RequestBody FilledFormDTO filledForm) {
        return null;
    }

    /**
     *
     * @param id submitted form id to be approved
     * @return approved filled form id
     */
    @PutMapping("/filled/{id}/approve")
    @ResponseStatus(HttpStatus.OK)
    Long approveSubmittedForm(@PathVariable("id") Long id){
        //TODO show to Ofer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        new FilledFormWithStatusDTO();
        return null;
    }

    @PutMapping("/filled/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long submitFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    /**
     *
     * @param id filled/submitted form id to delete
     * @return id of deleted filled/submitted form
     */
    @DeleteMapping("/filled/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long deleteFilledForm(@PathVariable("id") Long id) {
        return null;
    }
}
