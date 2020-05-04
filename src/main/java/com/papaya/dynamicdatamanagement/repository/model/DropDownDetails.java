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
public class DropDownDetails extends AbstractInputField{
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
    @OneToMany(mappedBy = "dropDownDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Choice> choices = new ArrayList<>();

   /* @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "drop_down_details_value",
            joinColumns = @JoinColumn(name = "drop_down_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values = new ArrayList<>();*/
   @OneToMany(mappedBy = "dropDownDetails",
           cascade = CascadeType.ALL,
           orphanRemoval = true)
    List<Value> values = new ArrayList<>();

    public void addChoice(Choice choice){
        choices.add(choice);
        choice.setDropDownDetails(this);
    }

    public void removeChoice(Choice choice){
        choices.remove(choice);
        choice.setDropDownDetails(null);
    }

    public void addValue(Value value){
        values.add(value);
        value.setDropDownDetails(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.setDropDownDetails(null);
    }
}
