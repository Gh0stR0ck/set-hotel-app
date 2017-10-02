package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {

    private List<Room> rooms;

    public RoomManager() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public void deleteRoom(Room room){
        this.rooms.remove(room);
    }

    public void modifyRoom(int roomId){
        for(Room room : rooms) {
            if(room.getRoomNumber() == roomId) {
            }
        }
    }

    public List<Room> getRoomList() {
        return rooms;
    }
}
