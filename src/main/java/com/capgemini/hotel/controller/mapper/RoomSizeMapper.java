package com.capgemini.hotel.controller.mapper;

import com.capgemini.hotel.controller.dto.RoomSizeDTO;
import com.capgemini.hotel.model.RoomSize;

public class RoomSizeMapper {
    public static RoomSizeDTO map(RoomSize roomSize) {
        RoomSizeDTO roomSizeDTO = new RoomSizeDTO();
        roomSizeDTO.setLabel(roomSize.getLabel());
        roomSizeDTO.setName(roomSize.name());
        return roomSizeDTO;
    }

    public static RoomSize map(RoomSizeDTO roomSizeDTO) {
        return RoomSize.valueOf(roomSizeDTO.getName());
    }
}
