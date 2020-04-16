package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class SupplementaryWorkerInformationFormService implements FormService {
    @Override
    public Template getFormCreationTemplate(FormType formType) {
        return null;
    }

    @Override
    public EnumSet<FormType> getFormType() {
        return EnumSet.of(FormType.SUPPLEMENTARY_WORKER_INFORMATION,
                FormType.SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE,
                FormType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE);
    }
}
