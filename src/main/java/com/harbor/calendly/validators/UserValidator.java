package com.harbor.calendly.validators;

import com.harbor.calendly.model.User;
import com.harbor.calendly.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserValidator {

    @Autowired
    public UserRepo userRepo;

    public boolean checkIfUserExists(String email) {
        User user = userRepo.fetchUserByEmail(email);
        return user != null;
    }
}