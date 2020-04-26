package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.FilledFormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/me/org/{orgId}/project/{projectId}/filled-forms")
public class WorkerFilledFormController {
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
