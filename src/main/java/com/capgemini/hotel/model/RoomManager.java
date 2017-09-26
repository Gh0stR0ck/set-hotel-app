package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> rooms;

    public Room produceRoom(int roomNumber, RoomType roomType, RoomSize roomSize, RoomStatus roomStatus){
        Room room = new Room(roomNumber, roomType, roomSize, roomStatus);
        rooms.add(room);
        return room;
    }

    public RoomManager() {
        this.rooms = new ArrayList<>();

    }

    public List<Room> getRoomList() {
        return rooms;
    }

}
