package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> roomList;

    public RoomManager() {
        this.roomList = new ArrayList<>();

    }

    public List<Room> getRoomList() {
        return roomList;
    }

}
