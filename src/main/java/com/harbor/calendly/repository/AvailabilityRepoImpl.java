package com.harbor.calendly.repository;

import com.harbor.calendly.model.Availability;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AvailabilityRepoImpl implements AvailabilityRepo {

    @Override
    public Availability save(Availability availability) {
        return null;
    }

    @Override
    public Availability fetchAvailabilityByUserId(String userId) {
        return null;
    }
}
