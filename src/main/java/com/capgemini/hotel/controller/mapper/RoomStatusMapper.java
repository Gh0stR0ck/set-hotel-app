package com.capgemini.hotel.controller.mapper;

import com.capgemini.hotel.controller.dto.RoomStatusDTO;
import com.capgemini.hotel.model.RoomStatus;

public class RoomStatusMapper {
    public static RoomStatusDTO map(RoomStatus roomStatus) {
        RoomStatusDTO roomStatusDTO = new RoomStatusDTO();
        roomStatusDTO.setLabel(roomStatus.getLabel());
        roomStatusDTO.setName(roomStatus.name());
        return roomStatusDTO;
    }

    public static RoomStatus map(RoomStatusDTO roomStatusDTO) {
        return RoomStatus.valueOf(roomStatusDTO.getName());
    }
}
