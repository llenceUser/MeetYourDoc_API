package com.llence.meetyourdoc.repository;

import com.llence.meetyourdoc.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
