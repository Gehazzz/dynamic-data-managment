package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer/org/{orgId}/filled-forms")
public class CustomerFilledFormController {
    //will return all submitted filled forms related to customer org.
    //TODO add request optional parameter to include filled draft and approved or include all types. by default return only submitted
    @GetMapping
    List<FormPreviewDTO> getFilledForms() {
        return null;
    }

    /**
     *
     * @param customerFormSearch
     * @return filled by users forms from customer usage level
     */

    @GetMapping("/search")
    ///api/v1/org/{orgId}/project/{projectId}/customer/forms/search?status=submitted&userName=John&formType=dynamic&label=worker_expenses
    List<FormDTO> getSubmittedForms(CustomerFilledFormSearchDTO customerFormSearch) {
        return null;
    }



    @GetMapping("/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable("id") Long filledFormId, @RequestBody FilledFormDTO filledForm) {
        return null;
    }

    /**
     *
     * @param id submitted form id to be approved
     * @return approved filled form id
     */
    @PutMapping("/{id}/approve")
    @ResponseStatus(HttpStatus.OK)
    Long approveSubmittedForm(@PathVariable("id") Long id){
        new FilledFormWithStatusDTO();
        return null;
    }

    @PutMapping("/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long submitFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

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
