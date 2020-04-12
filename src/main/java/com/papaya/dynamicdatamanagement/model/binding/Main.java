package com.papaya.dynamicdatamanagement.model.binding;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;
import com.papaya.dynamicdatamanagement.model.elements.FormElementType;
import com.papaya.dynamicdatamanagement.model.elements.StringTextField;
import com.papaya.dynamicdatamanagement.model.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.model.elements.main.Form;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Main {
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        String name;
        int age;
     
    }
    public static void main(String[] args) {
        Form form = new Form();
        //Section section = new Section();
        StringTextField textField = new StringTextField();
        ObjectFieldBinding<String> userNameFieldBinding = new ObjectFieldBinding<>();
        //userNameFieldBinding.setProperty("Gena");
        textField.setBinding(userNameFieldBinding);
        form.add(textField);

        User user = new User();
        userNameFieldBinding.setBoundObject(user);

        AbstractInputField abstractInputField = (AbstractInputField) form.getMainSection().getFormElements().get(0);
        abstractInputField.setBinding(userNameFieldBinding);
    }

}
