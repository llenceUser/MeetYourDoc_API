package com.llence.meetyourdoc.service;

import com.llence.meetyourdoc.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    void cancelAppointment(Long id);
}
