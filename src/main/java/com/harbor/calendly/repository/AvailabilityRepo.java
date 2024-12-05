package com.harbor.calendly.repository;

import com.harbor.calendly.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepo extends JpaRepository<Availability, String> {

    public Availability save(Availability availability);
    public Availability fetchAvailabilityByUserId(String userId);
}
