package com.papaya.dynamicdatamanagement.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RadioGroupDetails extends AbstractInputField{
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
    @OneToMany(mappedBy = "radioGroupDetails", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Choice> choices = new ArrayList<>();

    @OneToMany(mappedBy = "radioGroupDetails", cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Value> values = new ArrayList<>();

    public void addChoice(Choice choice){
        choices.add(choice);
        choice.setRadioGroupDetails(this);
    }

    public void removeChoice(Choice choice){
        choices.remove(choice);
        choice.setRadioGroupDetails(null);
    }

    public void addValue(Value value){
        values.add(value);
        value.setRadioGroupDetails(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.setRadioGroupDetails(null);
    }
}
