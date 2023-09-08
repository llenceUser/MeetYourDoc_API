package com.llence.meetyourdoc.controller;


import com.llence.meetyourdoc.model.Patient;
import com.llence.meetyourdoc.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) {
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable("id") long id) {
        return new ResponseEntity<>(patientService.updatePatient(patient, id), HttpStatus.OK);
    }

    public ResponseEntity<String> deletePatient(long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient deleted successfully!", HttpStatus.OK);
    }
}
