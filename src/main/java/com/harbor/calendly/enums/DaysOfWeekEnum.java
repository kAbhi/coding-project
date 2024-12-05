package com.harbor.calendly.enums;

public enum DaysOfWeekEnum {
    SUNDAY(0, "Sunday"),
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday");

    private int order;
    private String day;

    DaysOfWeekEnum(int order, String day) {
        this.order = order;
        this.day = day;
    }
}
