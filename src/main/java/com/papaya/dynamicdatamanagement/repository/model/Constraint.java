package com.papaya.dynamicdatamanagement.repository.model;

public enum  Constraint {
    ASSERT_TRUE ("AssertTrue"),
    ASSERT_FALSE ("AssertFalse"),
    DECIMAL_MAX ("DecimalMax"),
    DECIMAL_MIN ("DecimalMin"),
    MAX ("Max"),
    MIN ("Min"),
    SIZE ("Size"),
    DIGITS ("Digits"),
    FUTURE ("Future"),
    PAST ("Past"),
    PATTERN ("Pattern"),
    NULL ("Null"),
    NOT_NULL ("NotNull"),
    NOT_EMPTY ("NotEmpty"),
    NOT_BLANK ("NotBlank");
   /* PHONE_NUMBER ("PhoneNumber"),
    CREDIT_CARD ("CreditCard");*/
    private final String constraint;

    Constraint(String constraint) {
        this.constraint = constraint;
    }
}
