package com.harbor.calendly.model;

import com.harbor.calendly.dto.UserDTO;
import com.harbor.calendly.utils.StringUtils;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;
//    private String phoneNumber;

    public static User transform(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setFullName(StringUtils.createFullName(userDTO.getFirstName(), userDTO.getLastName()));
        return user;
    }
}
