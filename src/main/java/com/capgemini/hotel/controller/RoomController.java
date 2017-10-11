package com.capgemini.hotel.controller;

import com.capgemini.hotel.controller.dto.*;
import com.capgemini.hotel.controller.mapper.RoomMapper;
import com.capgemini.hotel.model.*;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/Rooms")
public class RoomController {


    @Autowired
    RoomRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<RoomDTO> getAll(){
        Iterable<Room> roomList = repository.findAll();
        ArrayList<RoomDTO> roomDTOArrayList = new ArrayList<>();

        for(Room room : roomList){
            RoomDTO roomDTO;
            roomDTO = RoomMapper.map(room);
            roomDTOArrayList.add(roomDTO);
        }
        return roomDTOArrayList;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Room post(@RequestBody RoomDTO roomDTO) {
        Room room = RoomMapper.map(roomDTO);
        repository.save(room);
        return repository.findOne(room.getRoomNumber());
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public RoomDTO get(@PathVariable long roomNumber) {
        Room room = repository.findOne(roomNumber);
        return RoomMapper.map(room);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Room put(@RequestBody RoomDTO roomDTO) {
        Room room = RoomMapper.map(roomDTO);
        repository.save(room);
        return repository.findOne(room.getRoomNumber());
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public RoomDTO delete(@RequestBody RoomDTO roomDTO) {
        Room room = RoomMapper.map(roomDTO);
        repository.delete(room);
        return RoomMapper.map(room);
    }

//    public String setFormatType(Room room) {
//        switch(room.getRoomType()){
//            case BUDGET:
//                return  "Budget";
//            case LUXURY:
//                return "Luxury";
//            case NORMAL:
//                return "Normal";
//            default:
//                return "Budget";
//        }
//    }
//
//    public String setFormatSize(Room room) {
//        switch (room.getRoomSize()){
//            case ONEPERSON:
//                return "One Person";
//            case TWOPERSONS:
//                return "Two Persons";
//            case THREEFOURPERSONS:
//                return "Three-Four Persons";
//            case FIVESIXPERSONS:
//                return "Five-Six Persons";
//            default:
//                return "One Person";
//        }
//    }
//
//    public String setFormatStatus(Room room) {
//        switch (room.getRoomStatus()){
//            case BLOCKED:
//                return "Blocked";
//            case OPERATIONAL:
//                return "Operational";
//            default:
//                return "Operational";
//        }
//    }
}


