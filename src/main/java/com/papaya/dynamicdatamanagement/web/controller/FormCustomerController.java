package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.FilledFormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/customer/forms")
public class FormCustomerController {
    @GetMapping
    List<FormDTO> getForms(){return null;}

    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id){return null;}

    @GetMapping("/filled/{id}")
    FormDTO getFilledForm(@PathVariable("id") Long id){return null;}

    @PostMapping("/filled")
    @ResponseStatus(HttpStatus.CREATED)
    Long saveFilledForm(@RequestBody FilledFormDTO filledForm){return null;}

    @PutMapping("/filled/{filledFormId}")
    @ResponseStatus(HttpStatus.OK)
    Long updateFilledForm(@PathVariable( "filledFormId" ) Long filledFormId, @RequestBody FilledFormDTO filledForm){return null;}

    @DeleteMapping("/filled/{filledFormId}")
    @ResponseStatus(HttpStatus.OK)
    Long deleteFilledForm(@PathVariable( "filledFormId" ) Long filledFormId){return null;}
}
