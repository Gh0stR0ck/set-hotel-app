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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomSize getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(RoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
