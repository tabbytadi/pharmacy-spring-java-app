package com.example.pharmacy.service.impl;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.data.repo.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements com.example.pharmacy.service.MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public List<Medicine> getMedicines() {
        return this.medicineRepository.findAll();
    }

    @Override
    public Optional<Medicine> getMedicine(long id) {
        return this.medicineRepository.findById(id);
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
                }).orElseGet(()->
                     this.medicineRepository.save(medicine)
                );
    }

    @Override
    public void deleteMedicine(long id) {
        this.medicineRepository.deleteById(id);
    }
}
