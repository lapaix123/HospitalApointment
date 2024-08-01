package dev.lapaix.HospitalApointiment.model;

import dev.lapaix.HospitalApointiment.model.enumeration.EmploymentStatus;
import dev.lapaix.HospitalApointiment.model.enumeration.Gender;
import dev.lapaix.HospitalApointiment.model.enumeration.Qualification;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactInfo;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Qualification qualification;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;
}
