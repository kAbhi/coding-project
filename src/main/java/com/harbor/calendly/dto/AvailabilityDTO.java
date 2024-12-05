package com.harbor.calendly.dto;

import com.harbor.calendly.model.TimeSlot;
import lombok.Data;

import java.util.Map;

@Data
public class AvailabilityDTO {
    private String userId;
    private Map<String, TimeSlot> availabilityMap;
}
