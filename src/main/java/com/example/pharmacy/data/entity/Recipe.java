package com.example.pharmacy.data.entity;

import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recipe extends BaseEntity {
    private LocalDate creationDate;

    @ManyToOne  //edin edinstven doktor moje da pishe receptata
    private Doctor doctor;
}
