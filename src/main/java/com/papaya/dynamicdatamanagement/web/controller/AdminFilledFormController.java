package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/filled-forms")
public class AdminFilledFormController {
    /**
     * @return all filled forms
     */
    @GetMapping
    List<FormPreviewDTO> getAllFilledForms() {
        return null;
    }

    @GetMapping("/search")
        ///api/v1/org/{orgId}/project/{projectId}/customer/forms/search?status=submitted&userName=John&formType=dynamic&label=worker_expenses
    List<FormDTO> getSubmittedForms(AdminFilledFormSearchDTO customerFormSearch) {
        return null;
    }

    /**
     * @param id filled form id
     * @return it will be form with subtype form and with bounded data
     */
    @GetMapping("/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm) {
        return null;
    }

    //TODO we do not need additional methods to change status we can do it at update method status will be one of the available parameters;

    /**
     * admin will update filled form: filled data can be changed, status can be changed
     *
     * @param id                   filled form id to be managed
     * @param filledFormDTO filled form
     * @return approved filled form id
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable Long id, @RequestBody FilledFormDTO filledFormDTO) {
        //TODO: validate that status is draft in any other case it can't be updated
        return null;
    }

    @PutMapping("/{id}/approve")
    @ResponseStatus(HttpStatus.OK)
    Long approveSubmittedForm(@PathVariable("id") Long id) {
        new FilledFormWithStatusDTO();
        return null;
    }

    @PutMapping("/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long submitFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteFilledForm(@PathVariable("id") Long id) {
    }
}
