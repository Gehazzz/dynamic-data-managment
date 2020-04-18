package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import org.springframework.stereotype.Service;

@Service
public class SupplementaryWorkerInformationFormService implements FormService {
    @Override
    public Template getFormCreationTemplate(FormType formType) {
        return null;
    }

    @Override
    public FormType.Service getType() {
        return FormType.Service.SUPPLEMENTARY_WORKER_INFORMATION;
    }
}
