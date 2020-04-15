package com.papaya.dynamicdatamanagement.repository.model.template;

public enum InputJavaType {
    BYTE_TYPE("byte"),
    SHORT_TYPE("short"),
    INT_TYPE("int"),
    LONG_TYPE("long"),
    FLOAT_TYPE("float"),
    DOUBLE_TYPE("double"),
    CHAR_TYPE("char"),
    BOOLEAN_TYPE("boolean"),
    STRING_TYPE("String"),
    LOCAL_DATE_TIME("LocalDateTime");

    private final String type;

    InputJavaType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
