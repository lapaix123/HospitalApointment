package dev.lapaix.HospitalApointiment.model;

import dev.lapaix.HospitalApointiment.model.enumeration.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime startingLocalDateTime;
    private LocalDateTime endingLocalDateTime;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private Nurse registeredBy;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @PrePersist
    public void prePersist() {
        if (endingLocalDateTime == null) {
            endingLocalDateTime = startingLocalDateTime.plusMinutes(30);
        }
    }
}
