package com.harbor.calendly.model;

import com.harbor.calendly.dto.AvailabilityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Availability(User user, LocalDateTime startTime, LocalDateTime endTime) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
    }

//    public static Availability transform(AvailabilityDTO availabilityDTO) {
//        Availability availability = new Availability();
//        availability.setUserId(availabilityDTO.getUserId());
//        availability.setAvailabilityMap(availabilityDTO.getAvailabilityMap());
//        return availability;
//    }
}
