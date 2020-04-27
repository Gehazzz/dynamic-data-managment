package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
//@RestController
@RequestMapping("/api/v1/me/org/{orgId}/project/{projectId}/forms")
public class FormWorkerController {

    @GetMapping("/form")
    //get forms to fill by user
    List<FormPreviewDTO> getForms(){return null;}

    @GetMapping("form/search")
    List<FormPreviewDTO> searchForms(WorkerFormSearchDTO workerFormSearch) {
        return null;
    }

    //get filled form by filled formId (submmisionId if filledForm doesn't exist return form without bindings)
    @GetMapping("/form/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}

    @PostMapping("/filled")
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/filled/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/filled/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long submitFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    @DeleteMapping("/filled/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long deleteFilledForm(@PathVariable("id") Long id) {
        return null;
    }
}
