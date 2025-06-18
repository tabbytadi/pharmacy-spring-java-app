package com.example.pharmacy.service.impl;

import com.example.pharmacy.data.entity.Recipe;
import com.example.pharmacy.data.repo.RecipeRepository;
import com.example.pharmacy.service.RecipeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, long id) {
        return recipeRepository.findById(id)
                .map(existingRecipe -> {
                    existingRecipe.setCreationDate(recipe.getCreationDate());
                    existingRecipe.setDoctor(recipe.getDoctor());
                    return recipeRepository.save(existingRecipe);
                })
                .orElseGet(() -> recipeRepository.save(recipe));
    }

    @Override
    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<Recipe> getAllRecipesByCreationDateAndDoctorId(LocalDate creationDate, long id) {
        return this.recipeRepository.findAllByCreationDateAndDoctorId(creationDate, id);
    }

    @Override
    public List<Recipe> getAllRecipesByCreationDateAndDoctorNameContains(LocalDate creationDate, String doctorName) {
        return this.recipeRepository.findAllByCreationDateAndDoctorNameContains(creationDate, doctorName);
    }
}