package com.example.pharmacy.web.view;

import com.example.pharmacy.data.entity.Medicine;
import com.example.pharmacy.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class MedicineViewController {
    private final MedicineService medicineService;

    @GetMapping
    public String getMedicines(Model model) {
        List<Medicine> medicines = medicineService.getMedicines();
        model.addAttribute("medicines", medicines);
        return "medicines/medicines.html";
    }

    @GetMapping("/create-medicine")
    public String showCreateMedicine(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicines/create-medicine";
    }

    @PostMapping("/create")
    public String createMedicine(Medicine medicine) {
        this.medicineService.createMedicine(medicine);
        return "redirect:/medicines";
    }

    @GetMapping("/edit-medicine/{id}")
    public String showEditMedicine( Model model, @PathVariable long id) {
        model.addAttribute("medicine", this.medicineService.getMedicine(id));
        return "medicines/edit-medicine";
    }

    @PostMapping("/update/{id}")
    public String updateMedicine(@PathVariable long id, Medicine medicine) {
        this.medicineService.updateMedicine(medicine, id);
        return "redirect:/medicines";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable int id) {
        this.medicineService.deleteMedicine(id);
        return "redirect:/medicines";
    }

}
