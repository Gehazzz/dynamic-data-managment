package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.FilledFormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormTypeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FormWorkerController {

    @GetMapping
    List<FormListElementDTO> getForms(){return null;}
    //get filled form by filled forId (submmisionId if filledForm doesn't exist return form without bindings)
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createFilledForm(@RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    ///api/v2/org/{orgId}/project/{projectId}/worker-contract/{workerContractId}/submission/{submissionId}
    @PutMapping("/{id}/submit")
    @ResponseStatus(HttpStatus.OK)
    Long saveFilledForm(@PathVariable Long Id, @RequestBody FilledFormDTO filledForm){return null;}

    class FormListElementDTO{
        Long formId;
        Long submissionId;//filled form
        SubmissionStatus submissionStatus;
        String formLabel;
        boolean isBind;
    }
    //filled status
    enum SubmissionStatus{
        SAVED,
        SUBMITTED,
        APPROVED;
    }
}
