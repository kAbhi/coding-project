package com.harbor.calendly.service;

import com.harbor.calendly.dto.UserDTO;
import com.harbor.calendly.model.User;

public interface UserService {

    public User save(UserDTO userDTO);
    public User fetchUserByEmail(String email);
}
