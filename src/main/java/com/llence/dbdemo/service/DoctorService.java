package com.llence.dbdemo.service;

import com.llence.dbdemo.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(long id);
    Doctor updateDoctor(Doctor doctor, long id);
    void deleteDoctor(long id);
}
