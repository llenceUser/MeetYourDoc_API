package com.llence.meetyourdoc.repository;

import com.llence.meetyourdoc.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
