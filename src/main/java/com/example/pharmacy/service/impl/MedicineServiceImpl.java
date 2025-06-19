package com.example.pharmacy.service.impl;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.data.repo.MedicineRepository;
import com.example.pharmacy.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicines() {
        return this.medicineRepository.findAll();
    }

    @Override
    public Medicine getMedicine(long id) {
        return this.medicineRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine with id=" + id + " not found!"));
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        return this.medicineRepository.save(medicine);
    }

    @Override
    public Medicine updateMedicine(Medicine medicine, long id) {
        return this.medicineRepository.findById(id)
                .map(medicine1 -> {
                    medicine1.setName(medicine.getName());
                    return this.medicineRepository.save(medicine1);
                }).orElseGet(() ->
                        this.medicineRepository.save(medicine)
                );
    }

    @Override
    public void deleteMedicine(long id) {
        this.medicineRepository.deleteById(id);
    }

    @Override
    public List<Medicine> getMedicinesByName(String name) {
        return this.medicineRepository.findByName(name);
    }

    @Override
    public List<Medicine> getMedicinesByNameStartsWith(String name) {
        return this.medicineRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Medicine> getMedicinesByNameStartsWithAndAgeAppropriatenessGreaterThan(String name, int age) {
        return this.medicineRepository.findByNameStartsWithAndAgeAppropriatenessGreaterThan(name, age);
    }

    @Override
    public List<Medicine> getMedicinesByAgeAppropriatenessGreaterThanAndNeedsRecipe(int age, boolean needsRecipe) {
        return this.medicineRepository.findByAgeAppropriatenessGreaterThanAndNeedsRecipe(age, needsRecipe);
    }
}