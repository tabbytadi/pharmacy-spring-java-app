package com.example.pharmacy.web.api;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicines")
public class MedicineApiController {
    private final MedicineService medicineService;

    @GetMapping
    public List<Medicine> getMedicines() {
        return medicineService.getMedicines();
    }
    @GetMapping("/{id}")
    public Optional<Medicine> getMedicine(@PathVariable Long id) {
        return this.medicineService.getMedicine(id);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return this.medicineService.createMedicine(medicine);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(@RequestBody Medicine medicine, @PathVariable long id) {
        return this.medicineService.updateMedicine(medicine, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable long id) {
        this.medicineService.deleteMedicine(id);
        }
}