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
@Slf4j
@RestController
@RequestMapping("/api/admin/forms")
public class FormAdminController {
    @GetMapping
    List<FormDTO> getAllForms(){return null;}
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}

    @GetMapping
    //Can replace all search methods
    List<FormDTO> searchForms(SearchFormDTO searchFormDTO){return null;}

    @GetMapping(params = "formSubType")
    List<FormDTO> getForms(FormSubTypeDTO formSubType){return null;}

    @GetMapping(params = {"formSubType", "usageLevel"})
    List<FormDTO> getForms(FormSubTypeDTO formSubType, UsageLevelDTO usageLevel){return null;}

    @GetMapping(params = {"formSubType", "usageLevels"})
    List<FormDTO> getForms(FormSubTypeDTO formSubType, List<UsageLevelDTO> usageLevels){return null;}

    @GetMapping(params = {"formSubType", "usageLevels"})
    List<FormDTO> getForms(FormTypeDTO formType, FormSubTypeDTO formSubType){return null;}

    @GetMapping(params = {"formType", "formSubType", "usageLevel"})
    List<FormDTO> getForms(FormTypeDTO formType, FormSubTypeDTO formSubType, UsageLevelDTO usageLevel){return null;}

    @GetMapping(params = {"formType", "formSubType", "usageLevels"})
    List<FormDTO> getForms(FormTypeDTO formType, FormSubTypeDTO formSubType, List<UsageLevelDTO> usageLevels){return null;}

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
    FormDTO assignFormUsageLevel(@RequestBody List<UsageLevelDTO> usageLevel){return null;}
}
