package dev.lapaix.HospitalApointiment.model;

import dev.lapaix.HospitalApointiment.model.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String nId;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String address;
    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

}
