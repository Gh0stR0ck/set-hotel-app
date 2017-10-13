package com.capgemini.hotel.controller.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

public class RoomDTO{
    private Long roomNumber;

    @Length(max = 25, min = 1, message = "Room name must be between 1 and 25 characters.")
    private String roomName;
    @Valid
    private RoomTypeDTO roomType;
    @Valid
    private RoomSizeDTO roomSize;
    @Valid
    private RoomStatusDTO roomStatus;



    public RoomDTO() {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypeDTO getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeDTO roomType) {
        this.roomType = roomType;
    }

    public RoomSizeDTO getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(RoomSizeDTO roomSize) {
        this.roomSize = roomSize;
    }

    public RoomStatusDTO getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatusDTO roomStatus) {
        this.roomStatus = roomStatus;
    }
}
