package com.capgemini.hotel.controller.dto;

public class RoomStatusDTO {
    private String name;
    private String label;

    public RoomStatusDTO(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
