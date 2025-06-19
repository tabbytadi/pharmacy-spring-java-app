package com.example.pharmacy.data.repo;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.data.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByCreationDateAndDoctorId(LocalDate dateCreation, long doctorId);
    List<Recipe> findAllByCreationDateAndDoctorNameContains(LocalDate dateCreation, String doctorName);
    List<Recipe> findAllByCreationDateAndDoctorNameStartsWith(LocalDate dateCreation, String doctorName);
}
