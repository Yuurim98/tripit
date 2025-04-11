package com.tripit.tripit_backend.travel.domain.model;

import java.util.Arrays;

public enum ContentType {
    TOURIST_SPOT(12),
    CULTURE_FACILITY(14),
    FESTIVAL(15),
    TRAVEL_COURSE(25),
    LEPORTS(28),
    LODGING(32),
    SHOPPING(38),
    FOOD(39);

    private final int id;

    ContentType(int id) {
        this.id = id;
    }

    public static boolean isValid(int id) {
        return Arrays.stream(values())
            .anyMatch(type -> type.id == id);
    }
}
