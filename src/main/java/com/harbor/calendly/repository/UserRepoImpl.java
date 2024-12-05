package com.harbor.calendly.repository;

import com.harbor.calendly.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRepoImpl implements UserRepo {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User fetchUserByEmail(String email) {
        return null;
    }

    @Override
    public User fetchUserByUserId(String userId) {
        return null;
    }
}
