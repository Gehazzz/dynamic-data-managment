package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/me/org/{orgId}/project/{projectId}/filled-forms")
public class WorkerFilledFormController {
    //TODO: change from worker to user
    
    //TODO Worker can't search and see his filled forms? if he can, why it's separated from form?
    // We will have to execute two requests to show users forms one for filled forms and second for forms
    @GetMapping
    List<FormPreviewDTO> getFilledForms() {
        return null;
    }

    @GetMapping("/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/search")
    List<FormPreviewDTO> searchForms(WorkerFormSearchDTO workerFormSearch) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long submitFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long deleteFilledForm(@PathVariable("id") Long id) {
        return null;
    }
}
