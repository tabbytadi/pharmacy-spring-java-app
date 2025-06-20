package com.example.pharmacy.service.impl;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.data.repo.MedicineRepository;
import com.example.pharmacy.dto.CreateMedicineDTO;
import com.example.pharmacy.dto.MedicineDTO;
import com.example.pharmacy.service.MedicineService;
import com.example.pharmacy.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<MedicineDTO> getMedicines() {

        return
                this.mapperUtil
                        .mapList(
                                this.medicineRepository.findAll(), MedicineDTO.class);
    }

    @Override
    public MedicineDTO getMedicine(long id) {
        return
                this.mapperUtil.getModelMapper().map(
                        this.medicineRepository
                                .findById(id).orElseThrow(()
                                        -> new RuntimeException("Medicine with id=" + id + " not found!")),
                        MedicineDTO.class);
    }

    @Override
    public CreateMedicineDTO createMedicine(CreateMedicineDTO medicine) {
        return mapperUtil.getModelMapper()
                .map(this.medicineRepository
                        .save(mapperUtil.getModelMapper()
                                .map(medicine, Medicine.class)), CreateMedicineDTO.class);

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