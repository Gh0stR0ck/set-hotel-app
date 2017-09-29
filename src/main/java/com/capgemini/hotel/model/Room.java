package com.capgemini.hotel.model;

public class Room{
    private int roomNumber;
    private RoomType roomType;
    private RoomSize roomSize;
    private RoomStatus roomStatus;

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomSize getRoomSize() {
        return roomSize;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setRoomSize(RoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
