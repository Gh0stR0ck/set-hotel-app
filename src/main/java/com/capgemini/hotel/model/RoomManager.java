package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomManager {

    // Fields
    private List<Room> roomList;

    // Constructor
    public RoomManager() {
        this.roomList = new ArrayList<>();
    }

    // ---------
    // Methods
    // ---------

    // delete a room from roomlist
    public void deleteRoom (Room room){
        this.roomList.remove(room);
    }

    // add room to roomlist
    public void addRoom (Room room){

        if (room == null){
            return;
            // Case of inserting a null object in method
        }

        Room foundRoom = null;

        for (Room currentRoom : roomList){
            if (currentRoom.getRoomNumber() == room.getRoomNumber()){
                foundRoom = currentRoom;
                break;
            }
        }

        if (foundRoom !=null) {
            // Remove and than add to 'modify' room
            roomList.remove(foundRoom);
        }
        // add new room
        roomList.add(room);


    }

    public List<Room> getRoomList() {
        return  Collections.unmodifiableList(roomList);
    }


    // return a room based on ID
    public Room getRoom(int roomId){

        for (Room room: roomList){
            if(room.getRoomNumber() == roomId)
                return room;
        }
        return null;
    }
}

