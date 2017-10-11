package com.capgemini.hotel.controller.dto;

public class RoomDTO{
    private Long roomNumber;
    private RoomTypeDTO roomType;
    private RoomSizeDTO roomSize;
    private RoomStatusDTO roomStatus;

    public RoomDTO() {
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypeDTO getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeDTO roomType) {
        this.roomType = roomType;
    }

    public RoomSizeDTO getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(RoomSizeDTO roomSize) {
        this.roomSize = roomSize;
    }

    public RoomStatusDTO getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatusDTO roomStatus) {
        this.roomStatus = roomStatus;
    }
}

//public class RoomDTO extends Room {
//    String formatType;
//    String formatSize;
//    String formatStatus;
//
//    public RoomDTO() {
//        super();
//    }
//
//    public void setFormatType(String formatType) {
//        this.formatType = formatType;
//    }
//
//    public void setFormatSize(String formatSize) {
//        this.formatSize = formatSize;
//    }
//
//    public void setFormatStatus(String formatStatus) {
//        this.formatStatus = formatStatus;
//    }
//
//public String getFormatType() {
//        switch(getRoomType()){
//            case BUDGET:
//                formatType = "Budget";
//                break;
//            case LUXURY:
//                formatType = "Luxury";
//                break;
//            case NORMAL:
//                formatType = "Normal";
//                break;
//            default:
//                formatType = "Budget";
//                break;
//        }
//        return formatType;
//    }
//
//    public String getFormatSize() {
//        switch (getRoomSize()){
//            case ONEPERSON:
//                formatSize = "One Person";
//                break;
//            case TWOPERSONS:
//                formatSize = "Two Persons";
//                break;
//            case THREEFOURPERSONS:
//                formatSize = "Three-Four Persons";
//                break;
//            case FIVESIXPERSONS:
//                formatSize = "Five-Six Persons";
//                break;
//            default:
//                formatSize = "One Person";
//                break;
//        }
//        return formatSize;
//    }
//
//    public String getFormatStatus() {
//        switch (getRoomStatus()){
//            case BLOCKED:
//                formatStatus = "Blocked";
//                break;
//            case OPERATIONAL:
//                formatStatus = "Operational";
//                break;
//            default:
//                formatStatus = "Operational";
//                break;
//        }
//        return formatStatus;
//    }
//
//}
