package com.capgemini.hotel.model;

public enum RoomSize {
    ONEPERSON ( "1-person room"), TWOPERSONS("2-person room"), THREEFOURPERSONS("3/4-person room"), FIVESIXPERSONS("5/6-person room");


    private String label;

    RoomSize(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
