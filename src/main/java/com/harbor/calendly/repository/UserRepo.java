package com.harbor.calendly.repository;

import com.harbor.calendly.model.User;

public interface UserRepo {

    public User save(User user);
    public User fetchUserByEmail(String email);

}
