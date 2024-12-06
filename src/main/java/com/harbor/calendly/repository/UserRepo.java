package com.harbor.calendly.repository;

import com.harbor.calendly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

    public User save(User user);
    public User findByEmail(String email);
    public User findById(Long id);

}
