package com.llence.dbdemo.repository;

import com.llence.dbdemo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
