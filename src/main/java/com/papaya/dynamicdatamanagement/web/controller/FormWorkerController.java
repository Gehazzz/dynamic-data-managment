package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.FilledFormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormPreviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/me/org/{orgId}/project/{projectId}/forms")
public class FormWorkerController {

    @GetMapping
    //get forms to fill by user
    List<FormPreviewDTO> getForms(){return null;}
    //get filled form by filled formId (submmisionId if filledForm doesn't exist return form without bindings)
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long submitFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}
}
