package com.capgemini.hotel.model;

public class Room{
    private int roomNumber;
    private RoomType roomType;
    private RoomSize roomSize;
    private RoomStatus roomStatus;

    public Room(int roomNumber, RoomType roomType, RoomSize roomSize, RoomStatus roomStatus) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomSize = roomSize;
        this.roomStatus = roomStatus;
    }

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
}
