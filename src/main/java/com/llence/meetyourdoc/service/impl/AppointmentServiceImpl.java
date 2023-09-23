package com.llence.meetyourdoc.service.impl;

import com.llence.meetyourdoc.exception.ResourceNotFoundException;
import com.llence.meetyourdoc.model.Appointment;
import com.llence.meetyourdoc.repository.AppointmentRepository;
import com.llence.meetyourdoc.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment", "Id", id)
        );
    }

    @Override
    public void cancelAppointment(Long id) {
        appointmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment", "Id", id)
        );
    }
}