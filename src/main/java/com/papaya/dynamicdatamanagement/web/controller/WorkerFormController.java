package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormPreviewDTO;
import com.papaya.dynamicdatamanagement.web.dto.WorkerFormSearchDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/me/org/{orgId}/project/{projectId}/forms")
public class WorkerFormController {
    @GetMapping
        //get forms to fill by user
    List<FormPreviewDTO> getForms(){return null;}

    @GetMapping("/search")
    List<FormPreviewDTO> searchForms(WorkerFormSearchDTO workerFormSearch) {
        return null;
    }

    //get filled form by filled formId (submmisionId if filledForm doesn't exist return form without bindings)
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}
}
