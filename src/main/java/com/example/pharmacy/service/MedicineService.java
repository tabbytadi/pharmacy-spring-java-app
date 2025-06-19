package com.example.pharmacy.service;

import com.example.pharmacy.data.entity.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> getMedicines();

    Medicine getMedicine(long id);

    Medicine createMedicine(Medicine medicine);

    Medicine updateMedicine(Medicine medicine, long id);

    void deleteMedicine(long id);

    List<Medicine> getMedicinesByName(String name);
    List<Medicine> getMedicinesByNameStartsWith(String name);
    List<Medicine> getMedicinesByNameStartsWithAndAgeAppropriatenessGreaterThan(String name, int age);
    List<Medicine> getMedicinesByAgeAppropriatenessGreaterThanAndNeedsRecipe(int age, boolean needsRecipe);
}