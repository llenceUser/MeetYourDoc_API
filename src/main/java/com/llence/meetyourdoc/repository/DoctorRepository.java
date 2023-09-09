package com.llence.meetyourdoc.repository;

import com.llence.meetyourdoc.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public Doctor findByEmail(String email);
}
