package com.harbor.calendly.validators;

import com.harbor.calendly.model.User;
import com.harbor.calendly.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class UserValidator {

    @Autowired
    public UserRepo userRepo;

    public boolean checkIfUserExistsByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return user != null;
    }

    public boolean checkIfUserExistsByUserId(Long userId) {
        Optional<User> user = userRepo.findById(userId);
        return user.isPresent();
    }
}
