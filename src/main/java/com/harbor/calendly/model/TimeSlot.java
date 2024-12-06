package com.harbor.calendly.model;

import lombok.Data;

import java.sql.Time;

@Data
public class TimeSlot {

    private Time startTime;
    private Time endTime;
}
