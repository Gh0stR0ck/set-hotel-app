package com.capgemini.hotel.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class RoomStatusDTO {

    @NotEmpty(message = "Room status must be specified.")
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
