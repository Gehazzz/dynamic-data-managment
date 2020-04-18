package com.papaya.dynamicdatamanagement;

import com.papaya.dynamicdatamanagement.form.elements.main.not_relevant_enums.FormServiceType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import org.junit.jupiter.api.Test;

public class EnumTest {
    @Test
    void enumTest(){
        System.out.println(FormType.SUPPLEMENTARY_WORKER_INFORMATION_TEMPLATE.name());
    }
}
