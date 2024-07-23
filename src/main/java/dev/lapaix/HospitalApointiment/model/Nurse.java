package dev.lapaix.HospitalApointiment.model;

import dev.lapaix.HospitalApointiment.model.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nurseId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactInfo;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "registeredBy")
    private Set<Appointment> appointments;
}
