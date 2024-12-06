package com.harbor.calendly.service;

import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.model.Availability;
import com.harbor.calendly.model.User;
import com.harbor.calendly.repository.AvailabilityRepo;
import com.harbor.calendly.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Availability> findOverlap(Long userId1, Long userId2) {
        if (userId1 == null || userId2 == null) {
            return new ArrayList<>();
        }
        List<Availability> user1Availability = availabilityRepo.findByUserId(userId1);
        List<Availability> user2Availability = availabilityRepo.findByUserId(userId2);

        List<Availability> overlappingAvailabilities = findOverlap(user1Availability, user2Availability);

        return overlappingAvailabilities;
    }

    private List<Availability> findOverlap(List<Availability> availabilities1, List<Availability> availabilities2) {
        return availabilities1.stream()
                .flatMap(a1 -> availabilities2.stream()
                        .filter(a2 -> a1.getEndTime().isAfter(a2.getStartTime()) && a1.getStartTime().isBefore(a2.getEndTime()))
                        .map(a2 -> new Availability(
                                a1.getUser(),
                                a2.getUser(),
                                a1.getStartTime().isAfter(a2.getStartTime()) ? a1.getStartTime() : a2.getStartTime(),
                                a1.getEndTime().isBefore(a2.getEndTime()) ? a1.getEndTime() : a2.getEndTime()
                        )))
                .collect(Collectors.toList());
    }
}
