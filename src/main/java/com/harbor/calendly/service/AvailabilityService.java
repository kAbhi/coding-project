package com.harbor.calendly.service;

import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.model.Availability;

import java.util.List;

public interface AvailabilityService {

    public Availability save(AvailabilityDTO availabilityDTO);
    public List<Availability> fetchAvailabilityByUserId(Long userId);

    List<Availability> findOverlap(Long userId1, Long userId2);
}
