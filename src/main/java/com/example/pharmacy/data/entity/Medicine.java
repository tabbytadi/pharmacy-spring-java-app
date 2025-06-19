package com.example.pharmacy.data.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medicine extends BaseEntity {

    private String name;

    private int ageAppropriateness;

    private boolean needsRecipe;
}
