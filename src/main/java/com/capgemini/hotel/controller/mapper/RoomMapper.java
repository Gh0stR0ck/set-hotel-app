package com.capgemini.hotel.controller.mapper;

import com.capgemini.hotel.controller.dto.RoomDTO;
import com.capgemini.hotel.model.Room;

public class RoomMapper {

    public static RoomDTO map(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setRoomName(room.getRoomName());
        roomDTO.setRoomType(RoomTypeMapper.map(room.getRoomType()));
        roomDTO.setRoomSize(RoomSizeMapper.map(room.getRoomSize()));
        roomDTO.setRoomStatus(RoomStatusMapper.map(room.getRoomStatus()));
        return roomDTO;
    }

    public static Room map(RoomDTO roomDTO){
        final Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setRoomName(roomDTO.getRoomName());
        room.setRoomType(RoomTypeMapper.map(roomDTO.getRoomType()));
        room.setRoomSize(RoomSizeMapper.map(roomDTO.getRoomSize()));
        room.setRoomStatus(RoomStatusMapper.map(roomDTO.getRoomStatus()));
        return room;
    }
}
