package com.papaya.dynamicdatamanagement.web.controller;

import com.papaya.dynamicdatamanagement.web.dto.FormDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormElementDTO;
import com.papaya.dynamicdatamanagement.web.dto.FormTypeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin/form-templates")
public class AdminFormTemplateController {
    /**
     * @return all form creation templates
     */
    @GetMapping
    List<FormTypeDTO> getAllFormCreationTemplates() {
        return null;
    }

    /**
     * @param formType form formType
     * @return form by formType
     */
    @GetMapping("/{formType}")
    FormDTO getFormCreationTemplate(@PathVariable("formType") FormTypeDTO formType) {
        return null;
    }


    @GetMapping("/available-elements")
    List<FormElementDTO> getFormAvailableElements() {
        return null;
    }
}
