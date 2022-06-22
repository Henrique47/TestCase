package com.teste.testeCase.Services;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordVerificationService implements PasswordVerification {

    @Override
    public Boolean isValidPassword(String password) {
        return (isRegexValid(password) && !hasCharRepeated(password));
    }

    private Boolean isRegexValid(String password) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()+\\-])(?:([\\da-zA-Z!@#$%^&*()+\\-])){9,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private Boolean hasCharRepeated(String password) {
        try {
            String[] listChar = password.split("");
            Arrays.sort(listChar);
            for (int i = 1; i < password.length(); i++) {
                if (listChar[i].equals(listChar[i - 1])) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
