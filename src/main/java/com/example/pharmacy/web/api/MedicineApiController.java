package com.example.pharmacy.web.api;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicines")
public class MedicineApiController {
    private final MedicineService medicineService;
    @GetMapping
    public List<Medicine> getMedicines() {

        return this.medicineService.getMedicines();
    }
    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable long id){
        return this.medicineService.getMedicine(id);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return this.medicineService.createMedicine(medicine);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(@RequestBody Medicine medicine,@PathVariable long id) {
        return this.medicineService.updateMedicine(medicine, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable long id) {
        this.medicineService.deleteMedicine(id);
    }

    @GetMapping("/by-name/{name}")
    public List<Medicine> getMedicinesByName(@PathVariable String name) {
        return this.medicineService.getMedicinesByName(name);
    }

    @GetMapping("/by-name-starts-with/{name}")
    public List<Medicine> getMedicinesByNameStartsWith(@PathVariable String name) {
        return this.medicineService.getMedicinesByNameStartsWith(name);
    }

    @GetMapping("/by-name/{name}/age-appropriateness/{age}")
    public List<Medicine> getMedicinesByNameStartsWithAndAgeAppropriatenessGreaterThan(@PathVariable String name, @PathVariable int age) {
        return this.medicineService.getMedicinesByNameStartsWithAndAgeAppropriatenessGreaterThan(name, age);
    }

    @GetMapping("/age-appropriateness/{age}/needs-recipe/{needsRecipe}")
    public List<Medicine> getMedicinesByAgeAppropriatenessGreaterThanAndNeedsRecipe(@PathVariable int age, @PathVariable boolean needsRecipe) {
        return this.medicineService.getMedicinesByAgeAppropriatenessGreaterThanAndNeedsRecipe(age, needsRecipe);
    }
}