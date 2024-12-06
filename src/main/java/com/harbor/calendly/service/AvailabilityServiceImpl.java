package com.harbor.calendly.service;

import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.model.Availability;
import com.harbor.calendly.repository.AvailabilityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepo availabilityRepo;

    @Override
    public Availability save(AvailabilityDTO availabilityDTO) {
//        Availability availability = Availability.transform(availabilityDTO);
//        return availabilityRepo.save(availability);
        return null;
    }

    @Override
    public Availability fetchAvailabilityByUserId(String userId) {
        return availabilityRepo.fetchAvailabilityByUserId(userId);
    }
}
