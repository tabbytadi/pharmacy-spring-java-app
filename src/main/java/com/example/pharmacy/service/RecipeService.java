package com.example.pharmacy.service;

import com.example.pharmacy.data.entity.Recipe;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getRecipes();

    Optional<Recipe> getRecipe(Long id);

    Recipe createRecipe(Recipe recipe);

    Recipe updateRecipe(Recipe recipe, long id);

    void deleteRecipe(long id);

    List<Recipe> getAllRecipesByCreationDateAndDoctorId(LocalDate creationDate, long id);

    List<Recipe> getAllRecipesByCreationDateAndDoctorNameContains(LocalDate creationDate, String doctorName);
}
