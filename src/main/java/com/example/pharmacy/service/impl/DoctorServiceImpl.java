package com.example.pharmacy.service.impl;

import com.example.pharmacy.data.entity.Doctor;
import com.example.pharmacy.data.repo.DoctorRepository;
import com.example.pharmacy.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctor(long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, long id) {
        return doctorRepository.findById(id)
                .map(existingDoctor -> {
                    existingDoctor.setName(doctor.getName());
                    return doctorRepository.save(existingDoctor);
                })
                .orElseGet(() -> doctorRepository.save(doctor));
    }

    @Override
    public void deleteDoctor(long id) {
        doctorRepository.deleteById(id);
    }
}