package com.papaya.dynamicdatamanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.form.elements.*;
import com.papaya.dynamicdatamanagement.form.elements.main.*;
import com.papaya.dynamicdatamanagement.form.validation.PatternValidator;
import com.papaya.dynamicdatamanagement.model_test.FormDTO;
import com.papaya.dynamicdatamanagement.model_test.SectionDTO;
import com.papaya.dynamicdatamanagement.repository.model.Constraint;
import com.papaya.dynamicdatamanagement.repository.model.ValidationRule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
public class InputsTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void createInputsTest() {
        List<TextField<?>> inputs = new ArrayList<>();
        List<TextField<?>> innerSectionInputs = new ArrayList<>();
        List<TextArea> textAreas = new ArrayList<>();
        List<Text> texts = new ArrayList<>();
        List<DropDown<?>> dropDowns = new ArrayList<>();
        List<RadioGroup<?>> radioGroups = new ArrayList<>();
        List<CheckboxGroup<?>> checkboxGroups = new ArrayList<>();
        List<Checkbox> checkboxes = new ArrayList<>();

        SectionDTO innerSection = SectionDTO.builder()
                .label("Some inner section")
                .index(8)
                .htmlId("innerSection")
                .hidden(false)
                .inputs(innerSectionInputs)
                .visible(true)
                .build();

        SectionDTO section = SectionDTO.builder()
                .label("Worker on boarding")
                .htmlId("mainSection")
                .hidden(false)
                .inputs(inputs)
                .textAreas(textAreas)
                .texts(texts)
                .dropDowns(dropDowns)
                .radioGroups(radioGroups)
                .checkboxGroups(checkboxGroups)
                .checkboxes(checkboxes)
                .sections(List.of(innerSection))
                .visible(true)
                .build();

        FormDTO form = FormDTO.builder()
                .id(1L)
                .label("Worker on boarding")
                .mainSectionDTO(section)
                .formType(FormType.WORKER_ON_BOARDING)
                .formSubType(FormSubType.FORM)
                .build();

        texts.add(createText(sectionDTOToSection(section), 0));
        inputs.add(createStringTextInput(sectionDTOToSection(section), 1));
        inputs.add(createStringTextInput(sectionDTOToSection(section), 2));
        textAreas.add(createTextArea(sectionDTOToSection(section), 3));
        dropDowns.add(createDropDown(sectionDTOToSection(section), 4));
        dropDowns.add(createDropDown(sectionDTOToSection(section), 7));
        radioGroups.add(createRadioGroupInput(sectionDTOToSection(section), 5));
        checkboxGroups.add(createCheckboxGroupInput(sectionDTOToSection(section), 9));
        checkboxes.add(createCheckbox(sectionDTOToSection(section), 10));

        innerSectionInputs.add(createStringTextInput(sectionDTOToSection(innerSection), 0));

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(form));

    }

    StringTextField createStringTextInput(Section section, int index) {
        PatternValidator patternValidator = PatternValidator.builder()
                .pattern(Pattern.compile("\\w+\\.?"))
                .message("Name allow alphabets only,not allow any special characters")
                .build();

        return StringTextField.innerBuilder()
                .index(index)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(false)
                .label("First name")
                .hint("First name")
                .required(true)
                .requiredMessage("First name is required")
                .enabled(true)
                .placeholder("Type here your name")
                .fieldValidators(List.of(patternValidator))
                .build();
    }

    IntegerTextField createIntegerTextInput() {
        return null;
    }

    TextArea createTextArea(Section section, int index) {
        return TextArea.builder()
                .index(index)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(false)
                .label("text area")
                .hint("type some text")
                .required(false)
                .requiredMessage(null)
                .enabled(true)
                .placeholder("Type here your some text")
                .htmlId("txar")
                .build();
    }

    Text createText(Section section, int index) {
        return Text.builder()
                .index(index)
                .parentSection(section)
                .showRemoveButton(false)
                .text("This is some text in form " + index)
                .build();
    }

    DropDown<?> createDropDown(Section section, int index) {
        return new DropDown<Integer>(2L,
                "someDropDown" + index,
                index,
                section,
                false,
                true,
                false,
                null,
                "Choose number",
                "Hint for you: choose number",
                true,
                true,
                "You should choose a number",
                Collections.emptyList(),
                null,
                List.of(1, 2, 3, 4, 5),
                "Choose number " + index,
                Integer.class
        );
    }

    RadioGroup<?> createRadioGroupInput(Section section, int index) {
        RadioGroup<String> radioGroup = new RadioGroup<>();
        radioGroup.setIndex(index);
        radioGroup.setParentSection(section);
        radioGroup.setVisible(true);
        radioGroup.setDiscarded(false);
        radioGroup.setShowRemoveButton(true);
        radioGroup.setChoiceLabel("Choose one " + index);
        radioGroup.setChoices(List.of("first choice", "second choice"));
        radioGroup.setEnabled(true);
        radioGroup.setHtmlId("chId");
        return radioGroup;
    }

    CheckboxGroup<?> createCheckboxGroupInput(Section section, int index) {
        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setIndex(index);
        checkboxGroup.setParentSection(section);
        checkboxGroup.setVisible(true);
        checkboxGroup.setDiscarded(false);
        checkboxGroup.setShowRemoveButton(true);
        checkboxGroup.setChoiceLabel("Choose several");
        checkboxGroup.setChoices(List.of("first choice", "second choice"));
        checkboxGroup.setEnabled(true);
        checkboxGroup.setHtmlId("chbId");
        return checkboxGroup;
    }

    Checkbox createCheckbox(Section section, int index) {
        return Checkbox.builder()
                .index(index)
                .parentSection(section)
                .visible(true)
                .discarded(false)
                .showRemoveButton(false)
                .enabled(true)
                .label("Send me something")
                .build();
    }

    Section sectionDTOToSection(SectionDTO sectionDTO){
        return Section.builder()
                .label(sectionDTO.getLabel())
                .htmlId(sectionDTO.getHtmlId())
                .hidden(sectionDTO.isHidden())
                .visible(true)
                .build();
    }
}
