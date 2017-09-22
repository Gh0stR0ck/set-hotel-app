package com.capgemini.hotel.core;

import java.time.LocalDateTime;

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
}
