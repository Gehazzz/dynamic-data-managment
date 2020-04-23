package com.papaya.dynamicdatamanagement.web.dto;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.web.controller.FormCustomerController;

public class CustomerFilledFormSearchDTO {
    //boolean isSubmitted;
    FormStatusDTO status;
    String userName;
    FormType formType;
    String label;
}
