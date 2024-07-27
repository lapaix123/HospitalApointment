package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.config.PasswordGenerator;
import dev.lapaix.HospitalApointiment.model.Nurse;
import dev.lapaix.HospitalApointiment.model.User;
import dev.lapaix.HospitalApointiment.model.enumeration.Role;
import dev.lapaix.HospitalApointiment.repository.NurseRepository;
import dev.lapaix.HospitalApointiment.repository.UserRepository;
import dev.lapaix.HospitalApointiment.service.EmailService;
import dev.lapaix.HospitalApointiment.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Nurse saveNurse(Nurse nurse) {
        //genarate Random password
        String randomPassword = PasswordGenerator.generateRandomPassword(10);

        // Create and save the user
        User user = new User();
        user.setEmail(nurse.getEmail()); // Use email as username or any unique identifier
        user.setPassword(passwordEncoder.encode(randomPassword)); // Encode the password
        user.setRole(Role.NURSE);

        userRepository.save(user);

      if(nurse.getEmail() != null)  {
          // Prepare email content
          String toEmail = nurse.getEmail();
          String subject = "New Nurse Registration";
          String body = "We are happy to notify you that you are now registered as a new nurse. "
                  + "Your login details are as follows:\n"
                  + "Username: " + nurse.getEmail() + "\n"
                  + "Password: " + randomPassword + "\n"
                  + "Please change your password after your first login.";

          // Send email
          emailService.sendEmail(toEmail, subject, body);
      }
        return nurseRepository.save(nurse);
    }

    @Override
    public Nurse getNurseById(Long nurseId) {
        return nurseRepository.findById(nurseId).orElse(null);
    }

    @Override
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse updateNurse(Long nurseId, Nurse nurse) {
        if (nurseRepository.existsById(nurseId)) {
            nurse.setNurseId(nurseId);
            return nurseRepository.save(nurse);
        }
        return null;
    }

    @Override
    public boolean deleteNurse(Long nurseId) {

        nurseRepository.deleteById(nurseId);
        return true;
    }
}