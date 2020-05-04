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
public class TextAreaDetails extends AbstractInputField {
    private String placeholder;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
   /* @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "text_area_details_value",
            joinColumns = @JoinColumn(name = "text_area_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;*/
   @OneToMany(mappedBy = "textAreaDetails",
           cascade = CascadeType.ALL,
           orphanRemoval = true)
    List<Value> values = new ArrayList<>();

    public void addValue(Value value){
        values.add(value);
        value.setTextAreaDetails(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.setTextAreaDetails(null);
    }
}
