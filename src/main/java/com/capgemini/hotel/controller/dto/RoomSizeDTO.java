package com.capgemini.hotel.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class RoomSizeDTO {
    @NotEmpty(message = "Room size must be specified.")
    private String name;

    private String label;

    public RoomSizeDTO(){
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
