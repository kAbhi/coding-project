package com.harbor.calendly.controller;

import com.harbor.calendly.constants.ControllerConstants;
import com.harbor.calendly.dto.AvailabilityDTO;
import com.harbor.calendly.model.Availability;
import com.harbor.calendly.service.AvailabilityService;
import com.harbor.calendly.validators.AvailabilityValidator;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/availability")
public class AvailabilityAPI {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private AvailabilityValidator availabilityValidator;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody AvailabilityDTO availabilityDTO) throws JSONException {
        if(!availabilityValidator.validateInputDTO(availabilityDTO)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new JSONObject(ControllerConstants.AVAILABILITY_ADD_ERROR_INVALID_INPUT));
        }
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(availabilityService.save(availabilityDTO));
    }

    @GetMapping("/{userId}")
    public ResponseEntity fetchUserByEmail(@PathVariable("userId") Long userId) throws JSONException {
        List<Availability> availability = availabilityService.fetchAvailabilityByUserId(userId);
        if(availability == null || availability.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new JSONObject(ControllerConstants.AVAILABILITY_DELETE_ERROR_MISSING));
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(availability);
    }

    @GetMapping("/overlap/{user1}/{user2}")
    public ResponseEntity<List<Availability>> findOverlap(@PathVariable("user1") Long userId1, @PathVariable("user2") Long userId2) {
        List<Availability> overlaps = availabilityService.findOverlap(userId1, userId2);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(overlaps);
    }

}
