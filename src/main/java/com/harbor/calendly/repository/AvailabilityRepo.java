package com.harbor.calendly.repository;

import com.harbor.calendly.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityRepo extends JpaRepository<Availability, String> {

    public Availability save(Availability availability);
    public List<Availability> findByUserId(Long userId);
}
