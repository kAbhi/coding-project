package com.harbor.calendly.controller;

import com.harbor.calendly.constants.ControllerConstants;
import com.harbor.calendly.dto.UserDTO;
import com.harbor.calendly.model.User;
import com.harbor.calendly.service.UserService;
import com.harbor.calendly.validators.UserValidator;
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
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    public UserService userService;

    @Autowired
    public UserValidator userValidator;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserDTO userDTO) throws JSONException {
        if(userValidator.checkIfUserExistsByEmail(userDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new JSONObject(ControllerConstants.ADD_USER_UNIQUE_ERROR_ALREADY_EXISTS));
        }
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(userService.save(userDTO));
    }

    @GetMapping("/{email}")
    public ResponseEntity fetchUserByEmail(@PathVariable("email") String email) throws JSONException {
        User user = userService.fetchUserByEmail(email);
        if(user == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new JSONObject(ControllerConstants.GET_USER_ERROR_DOES_NOT_EXISTS));
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(user);
    }

}
