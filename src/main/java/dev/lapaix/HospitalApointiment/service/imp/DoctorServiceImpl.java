package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.config.PasswordGenerator;
import dev.lapaix.HospitalApointiment.model.Doctor;
import dev.lapaix.HospitalApointiment.model.User;
import dev.lapaix.HospitalApointiment.model.enumeration.Role;
import dev.lapaix.HospitalApointiment.repository.DoctorRepository;
import dev.lapaix.HospitalApointiment.repository.UserRepository;
import dev.lapaix.HospitalApointiment.service.DoctorService;
import dev.lapaix.HospitalApointiment.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        //generate Random password
        String randomPassword = PasswordGenerator.generateRandomPassword(10);
        // Create and save the user
        User user = new User();
        user.setEmail(doctor.getEmail()); // Use email as username or any unique identifier
        user.setPassword(passwordEncoder.encode(randomPassword)); // Encode the password
        user.setRole(Role.DOCTOR);
        userRepository.save(user);

        if (doctor.getEmail() != null) {
            // Prepare email content
            String toEmail = doctor.getEmail();
            String subject = "New Doctor Registration";
            String body = "We are happy to notify you that you are now registered as a new doctor. "
                    + "Your login details are as follows:\n"
                    + "Username: " + doctor.getEmail() + "\n"
                    + "Password: " + randomPassword + "\n"
                    + "Please change your password after your first login.";

            // Send email
            emailService.sendEmail(toEmail, subject, body);
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Long doctorId, Doctor doctor) {
        Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setContactInfo(doctor.getContactInfo());
        existingDoctor.setGender(doctor.getGender());
        existingDoctor.setQualification(doctor.getQualification());
        existingDoctor.setEmploymentStatus(doctor.getEmploymentStatus());
        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}