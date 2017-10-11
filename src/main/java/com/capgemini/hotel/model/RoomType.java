package com.capgemini.hotel.model;

public enum RoomType {

    LUXURY("Luxury"), NORMAL("Normal"), BUDGET("Budget");

    private String label;

    RoomType(final String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

}
