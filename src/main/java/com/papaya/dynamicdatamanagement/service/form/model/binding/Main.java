package com.papaya.dynamicdatamanagement.service.form.model.binding;

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
//        Form form = new Form();
//        //SectionTemplate section = new SectionTemplate();
//        StringTextField textField = new StringTextField();
//        ObjectFieldBinding<String> userNameFieldBinding = new ObjectFieldBinding<>();
//        //userNameFieldBinding.setProperty("Gena");
//        textField.setBinding(userNameFieldBinding);
//        form.add(textField);
//
//        User user = new User();
//        userNameFieldBinding.setBoundObject(user);
//
//        AbstractInputField abstractInputField = (AbstractInputField) form.getMainSection().getFormElements().get(0);
//        abstractInputField.setBinding(userNameFieldBinding);
    }

}
