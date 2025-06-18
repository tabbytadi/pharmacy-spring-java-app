package com.example.pharmacy.service;

import com.example.pharmacy.data.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<Medicine> getMedicines();

    Optional<Medicine> getMedicine(Long id);

    Medicine createMedicine(Medicine medicine);

    Medicine updateMedicine(Medicine medicine, long id);

    void deleteMedicine(long id);
}
