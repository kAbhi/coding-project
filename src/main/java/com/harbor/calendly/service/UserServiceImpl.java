package com.harbor.calendly.service;

import com.harbor.calendly.dto.UserDTO;
import com.harbor.calendly.model.User;
import com.harbor.calendly.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public User save(UserDTO userDTO) {
        User user = User.transform(userDTO);
        return userRepo.save(user);
    }

    @Override
    public User fetchUserByEmail(String email) {
        return userRepo.fetchUserByEmail(email);
    }

    @Override
    public User fetchUserByUserId(Long userId) {
        return userRepo.fetchUserByUserId(userId);
    }
}
