package com.harbor.calendly.repository;

import com.harbor.calendly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public User save(User user);
    public User findByEmail(String email);
    public Optional<User> findById(Long id);

}
