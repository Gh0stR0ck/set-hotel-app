package com.capgemini.hotel.controller.mapper;

import com.capgemini.hotel.controller.dto.RoomTypeDTO;
import com.capgemini.hotel.model.RoomType;

public class RoomTypeMapper {

    public static RoomTypeDTO map(RoomType roomType){
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO();
        roomTypeDTO.setLabel(roomType.getLabel());
        roomTypeDTO.setName(roomType.name());
        return roomTypeDTO;
    }

    public static RoomType map(RoomTypeDTO roomTypeDTO) {
        return RoomType.valueOf(roomTypeDTO.getName());
    }

}
