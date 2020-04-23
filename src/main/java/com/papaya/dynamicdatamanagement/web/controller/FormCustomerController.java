package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.web.dto.CustomerFormSearchDTO;
import com.papaya.dynamicdatamanagement.web.dto.FilledFormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FilledFormWithStatusDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
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
    @GetMapping
    List<FormDTO> getForms() {
        return null;
    }

    @GetMapping("/search")
    ///api/v1/org/{orgId}/project/{projectId}/customer/forms/search?status=submitted&userName=John&formType=dynamic&label=worker_expenses
    List<FormDTO> getSubmittedForms(CustomerFormSearchDTO customerFormSearch) {
        return null;
    }

    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id) {
        return null;
    }

   /* @GetMapping("/filled/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/submitted/{id}")
    FormDTO getSubmittedForm(@PathVariable("id") Long id) {
        return null;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long saveFilledForm(@RequestBody FilledFormDTO filledForm) {
        return null;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable("id") Long filledFormId, @RequestBody FilledFormDTO filledForm) {
        return null;
    }

    /**
     *
     * @param id submitted form id to be approved
     * @return approved filled form id
     */
    @PutMapping("{id}/status/approved")
    @ResponseStatus(HttpStatus.OK)
    Long approveSubmittedForm(@PathVariable("id") Long id){
        //TODO show to Ofer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        new FilledFormWithStatusDTO();
        return null;
    }

    /**
     *
     * @param id filled/submitted form id to delete
     * @return id of deleted filled/submitted form
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long deleteFilledForm(@PathVariable("id") Long id) {
        return null;
    }
}
