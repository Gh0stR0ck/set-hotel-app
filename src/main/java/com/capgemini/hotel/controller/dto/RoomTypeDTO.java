package com.capgemini.hotel.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

public class RoomTypeDTO {

    @NotEmpty(message = "Room type must be specified.")
    private String name;
    private String label;

    public RoomTypeDTO(){
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
