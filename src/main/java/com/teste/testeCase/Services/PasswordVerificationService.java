package com.teste.testeCase.Services;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordVerificationService {

    private String _password;

    public Boolean passwordVerification(String password) {
        _password = password;

        return isValid();
    }

    private Boolean isValid() {
        return (isRegexValid() && !hasCharRepeated());
    }

    private Boolean isRegexValid() {
        //String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?:([\\da-zA-Z!@#$%^&*()-+])(?!\\1)){9,}$";
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()+\\-])(?:([\\da-zA-Z!@#$%^&*()+\\-])){9,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(_password);
        return matcher.matches();
    }

    private Boolean hasCharRepeated() {
        try {
            String[] listChar = _password.split("");
            Arrays.sort(listChar);
            for (int i = 1; i < _password.length(); i++) {
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
