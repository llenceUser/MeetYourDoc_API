package com.llence.meetyourdoc.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appointmentDateTime;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
}
