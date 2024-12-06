package com.harbor.calendly.repository;

import com.harbor.calendly.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepo extends JpaRepository<Availability, Long> {

    public Availability save(Availability availability);
    public List<Availability> findByUserId(Long userId);
}
