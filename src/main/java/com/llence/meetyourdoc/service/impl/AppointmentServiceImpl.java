package com.llence.meetyourdoc.service.impl;

import com.llence.meetyourdoc.model.Appointment;
import com.llence.meetyourdoc.repository.AppointmentRepository;
import com.llence.meetyourdoc.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return null;
    }
}