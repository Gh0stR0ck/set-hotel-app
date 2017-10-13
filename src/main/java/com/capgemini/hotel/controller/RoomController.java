package com.capgemini.hotel.controller;

import com.capgemini.hotel.controller.dto.*;
import com.capgemini.hotel.controller.mapper.RoomMapper;
import com.capgemini.hotel.model.*;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


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
    public Room post(@Valid @RequestBody RoomDTO roomDTO) {
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
    public Room put(@Valid @RequestBody RoomDTO roomDTO) {
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ArrayList<String> errors = new ArrayList<>();
        for (FieldError field : fieldErrors){
            errors.add(field.getDefaultMessage());
        }
        return errors;
    }
}


