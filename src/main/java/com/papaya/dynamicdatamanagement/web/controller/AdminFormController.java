package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/forms")
public class AdminFormController {
    /**
     * @return all forms
     */
    @GetMapping
    List<FormDTO> getAllForms() {
        return null;
    }

    /**
     * @param id form id
     * @return form by id, it can be form, form template or form creation template
     */
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id) {
        return null;
    }

    //@GetMapping
    //Can replace all search methods, filter by org, project, user, status (status - draft, published)
    List<FormDTO> searchForms(AdminFormSearchDTO adminFormSearchDTO) {
        return null;
    }

    /**
     * @param formType DYNAMIC, SUPPLEMENTARY_WORKER_INFORMATION
     * @return all forms of provided type
     */
    @GetMapping(params = "formType")
    List<FormDTO> getForms(FormTypeDTO formType) {
        return null;
    }

    /*@GetMapping("/{id}/available-elements")
    List<FormElementDTO> getFormAvailableElements(@PathVariable("id") Long id) {
        return null;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    FormDTO saveForm(@RequestBody FormDTO form) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FormDTO updateForm(@PathVariable("id") Long id, @RequestBody FormDTO formDTO) {
        return null;
    }

    @PutMapping("/{id}/publish")
    @ResponseStatus(HttpStatus.OK)
    FormDTO publishForm(@PathVariable("id") Long id) {
        return null;
    }

    @PutMapping("/{id}/usage-level")
    @ResponseStatus(HttpStatus.OK)
    FormDTO assignFormUsageLevel(@PathVariable("id") Long id, @RequestBody List<UsageLevelDTO> usageLevel) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteForm(@PathVariable("id") Long id) {
    }
}
