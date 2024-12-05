package com.harbor.calendly.repository;

import com.harbor.calendly.model.Availability;

public interface AvailabilityRepo {

    public Availability save(Availability availability);
    public Availability fetchAvailabilityByUserId(String userId);
}
