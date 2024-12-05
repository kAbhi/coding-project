package com.harbor.calendly.service;

import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.model.Availability;

public interface AvailabilityService {

    public Availability save(AvailabilityDTO availabilityDTO);
    public Availability fetchAvailabilityByUserId(String userId);
}
