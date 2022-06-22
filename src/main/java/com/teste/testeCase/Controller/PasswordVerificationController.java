package com.teste.testeCase.Controller;

import com.teste.testeCase.Services.PasswordVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PasswordVerificationController {
    @Autowired
    private PasswordVerificationService verificationService;

    @GetMapping("/verification/{password}")
    public Boolean VerificationPassword(@PathVariable String password) {
        return verificationService.isValidPassword(password);
    }
}
