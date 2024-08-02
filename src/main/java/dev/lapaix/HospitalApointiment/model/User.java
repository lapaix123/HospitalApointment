package dev.lapaix.HospitalApointiment.model;

import dev.lapaix.HospitalApointiment.model.enumeration.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

}
