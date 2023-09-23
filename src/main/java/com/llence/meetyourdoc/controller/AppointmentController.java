package com.llence.meetyourdoc.controller;

import com.llence.meetyourdoc.model.Appointment;
import com.llence.meetyourdoc.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.bookAppointment(appointment), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> cancelAppointment(@PathVariable("id") Long id) {
        appointmentService.cancelAppointment(id);
        return new ResponseEntity<String>("Appointment cancelled successfully", HttpStatus.OK);
    }
}
