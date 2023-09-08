package com.llence.meetyourdoc.service;

import com.llence.meetyourdoc.model.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(long id);
    Patient updatePatient(Patient patient, long id);
    void deletePatient(long id);
}
