package com.harbor.calendly.validators;

import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.enums.DaysOfWeekEnum;
import com.harbor.calendly.model.TimeSlot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Slf4j
@Component
public class AvailabilityValidator {

    @Autowired UserValidator userValidator;

    public boolean validateInputDTO(AvailabilityDTO availabilityDTO) {
        boolean userIdExists = userValidator.checkIfUserExistsByUserId(availabilityDTO.getUserId());
        boolean validAvailabilityDays = validateDays(availabilityDTO.getAvailabilityMap().keySet());
        boolean validTimeSlots = validateTimeSlots(availabilityDTO.getAvailabilityMap().values());

        return userIdExists && validAvailabilityDays && validTimeSlots;
    }

    private boolean validateDays(Set<String> daysList) {
        for(String day : daysList) {
            try {
                DaysOfWeekEnum.valueOf(day);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    private boolean validateTimeSlots(Collection<TimeSlot> timeSlotCollection) {
        for(TimeSlot timeSlot : timeSlotCollection) {
            if(timeSlot.getStartTime().compareTo(timeSlot.getEndTime()) >= 0) {
                return false;
            }
        }
        return true;
    }

}
