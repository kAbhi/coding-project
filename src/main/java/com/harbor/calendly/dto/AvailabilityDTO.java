package com.harbor.calendly.dto;

import com.harbor.calendly.model.Availability;
import com.harbor.calendly.model.TimeSlot;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class AvailabilityDTO {

    Long id;

    private Long userId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
