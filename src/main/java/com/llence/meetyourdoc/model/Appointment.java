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

    @Enumerated(EnumType.STRING)
    private Situation situation;

    private String purpose;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;
}
