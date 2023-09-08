package com.llence.meetyourdoc.service.impl;

import com.llence.meetyourdoc.exception.ResourceNotFoundException;
import com.llence.meetyourdoc.model.Doctor;
import com.llence.meetyourdoc.repository.DoctorRepository;
import com.llence.meetyourdoc.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(long id) {
        return doctorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "Id", id));
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, long id) {
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "Id", id));
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setAddress(doctor.getAddress());
        existingDoctor.setPhoneNo(doctor.getPhoneNo());
        doctorRepository.save(existingDoctor);
        return existingDoctor;
    }

    @Override
    public void deleteDoctor(long id) {
        doctorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "Id", id));
        doctorRepository.deleteById(id);
    }
}
