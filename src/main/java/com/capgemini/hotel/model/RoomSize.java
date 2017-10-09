package com.capgemini.hotel.model;

public enum RoomSize {
    ONEPERSON("1 person"),
    TWOPERSON("2 persons"),
    THREEFOURPERSON("3-4 persons"),
    FIVESIXPERSON("5-6 persons");

    private String label;

    RoomSize(final String label) {
        this.label = label;
    }

    public String getName() {
        return label;
    }
}
