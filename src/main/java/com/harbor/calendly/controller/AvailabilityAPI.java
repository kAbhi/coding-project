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
//        if(userValidator.checkIfUserExists(userDTO.getEmail())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new JSONObject(ControllerConstants.ADD_USER_UNIQUE_ERROR_ALREADY_EXISTS));
//        }
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(availabilityService.save(availabilityDTO));
    }

    @GetMapping("/{userId}")
    public ResponseEntity fetchUserByEmail(@PathVariable("userId") String userId) throws JSONException {
        Availability availability = availabilityService.fetchAvailabilityByUserId(userId);
        if(availability == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new JSONObject(ControllerConstants.AVAILABILITY_DELETE_ERROR_MISSING));
        }
        return ResponseEntity.ok(ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(availability));
    }

}
