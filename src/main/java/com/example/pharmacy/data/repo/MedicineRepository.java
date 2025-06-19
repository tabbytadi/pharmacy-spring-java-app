package com.example.pharmacy.data.repo;

import com.example.pharmacy.data.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByName(String name);
    List<Medicine> findByNameStartsWith(String name);
    List<Medicine> findByNameStartsWithAndAgeAppropriatenessGreaterThan(String name, int age);
    List<Medicine> findByAgeAppropriatenessGreaterThanAndNeedsRecipe(int age, boolean needsRecipe);
}
