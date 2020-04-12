package com.papaya.dynamicdatamanagement.data_model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractInputField extends AbstractFormElement {
    /**
     * The label of the input field. This label should be displayed
     * next to the input field itself, so that it is clear what input
     * the user is expected to give.
     */
    private String label;
    /**
     * Sets an optional hint for the input field. This hint may for example be
     * displayed as a info to the user next to the input field or as a
     * mouse-over popup.
     */
    private String hint;
    /**
     * Defines if this input field is mandatory and thus must be filled by the
     * user.
     */
    private boolean required = false;
    /**
     * Enables or disables an input field. Disabled input fields cannot be
     * filled out by the user.
     */
    private boolean enabled = true;
    /**
     * The message that is displayed to the user if he did not fill this
     * input field although it was defined as required.
     */
    private String requiredMessage;
}
