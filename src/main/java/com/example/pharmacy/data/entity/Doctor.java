package com.example.pharmacy.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Recipe> recipes;
}
