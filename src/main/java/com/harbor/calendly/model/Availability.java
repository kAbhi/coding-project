package com.harbor.calendly.model;

import com.harbor.calendly.dto.AvailabilityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Availability {

    private String id;
    private String userId;
    private Map<String, TimeSlot> availabilityMap;

    public static Availability transform(AvailabilityDTO availabilityDTO) {
        Availability availability = new Availability();
        availability.setId(UUID.randomUUID().toString());
        availability.setUserId(availabilityDTO.getUserId());
        availability.setAvailabilityMap(availabilityDTO.getAvailabilityMap());
        return availability;
    }
}
