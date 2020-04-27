package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.CustomerFormSearchDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormPreviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer/org/{orgId}/forms")
public class CustomerFormController {
    /**
     * should return all forms for customer usage level (all forms that the org and project have)
     */
    @GetMapping
    List<FormPreviewDTO> getForms() {
        return null;
    }

    @GetMapping("/search")
    List<FormPreviewDTO> searchForms(CustomerFormSearchDTO customerFormSearch) {
        return null;
    }

    /**
     * should return form by id for customer usage level
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    FormDTO getForm(@PathVariable("id") Long id) {
        return null;
    }

}
