package com.harbor.calendly.service;

import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.model.Availability;
import com.harbor.calendly.model.User;
import com.harbor.calendly.repository.AvailabilityRepo;
import com.harbor.calendly.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepo availabilityRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Availability save(AvailabilityDTO availabilityDTO) {
        User user = userRepo.findById(availabilityDTO.getUserId());
        Availability availability = new Availability(user, availabilityDTO.getStartTime(), availabilityDTO.getEndTime());
        Availability savedAvailabilityEntity = availabilityRepo.save(availability);
        return savedAvailabilityEntity;
    }

    @Override
    public List<Availability> fetchAvailabilityByUserId(Long userId) {
        return availabilityRepo.findByUserId(userId);
    }
}
