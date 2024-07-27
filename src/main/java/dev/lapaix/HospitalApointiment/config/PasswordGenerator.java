package dev.lapaix.HospitalApointiment.config;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGenerator {
    private static final SecureRandom secureRandom= new SecureRandom();
    public static String generateRandomPassword(int length){
        byte[] randomBytes=new byte[length];
        secureRandom.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes).substring(0,length);
    }
}
