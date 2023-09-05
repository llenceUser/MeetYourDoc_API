package com.llence.dbdemo.service;

import com.llence.dbdemo.model.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(long id);
    Patient updatePatient(Patient patient, long id);
    void deletePatient(long id);
}
