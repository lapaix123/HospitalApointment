package dev.lapaix.HospitalApointiment.model;

import dev.lapaix.HospitalApointiment.model.enumeration.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String password;

}
