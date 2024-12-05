package com.harbor.calendly.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public static String createFullName(String firstName, String lastName) {
        return firstName.concat(" ").concat(lastName);
    }
}
