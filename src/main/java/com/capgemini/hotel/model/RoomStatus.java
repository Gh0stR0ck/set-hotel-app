package com.capgemini.hotel.model;

public enum RoomStatus {

    OPERATIONAL("Operational"), BLOCKED("Blocked");

    private String label;

    RoomStatus(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
