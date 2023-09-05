package com.llence.dbdemo.service.impl;

import com.llence.dbdemo.exception.ResourceNotFoundException;
import com.llence.dbdemo.model.Patient;
import com.llence.dbdemo.repository.PatientRepository;
import com.llence.dbdemo.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(long id) {
        return patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "Id", id));
    }

    @Override
    public Patient updatePatient(Patient patient, long id) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "Id", id));

        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setPhoneNo(patient.getPhoneNo());
        patientRepository.save(existingPatient);
        return existingPatient;
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "Id", id));
        patientRepository.deleteById(id);
    }

}
