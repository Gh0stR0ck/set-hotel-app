package com.capgemini.hotel;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Hotel;
import com.capgemini.hotel.utils.Database;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.ResultSet;


public class App {

    public static Hotel hotel = new Hotel();

    public static void main(String[] args) throws Exception {
        System.out.println("Database");
        Database db = new Database(
                "capgemini-academy.ck17qz3qdemp.eu-west-1.rds.amazonaws.com",
                "hotel1",
                "capgemini",
                "hotel1");

        db.open();

        ResultSet resultSet = db.query("SELECT * FROM Room;");
//        Boolean resultSet = db.execute("SELECT * FROM Room;");

        while (resultSet.next()) {
            System.out.println("RoomNr: " + resultSet.getInt("roomNr") + " RoomType: " + resultSet.getInt("roomType") + " RoomSize: " + resultSet.getInt("roomSize") + " RoomStatus: " + resultSet.getInt("roomStatus"));
        }

        resultSet.close();

        db.close();
    }
}
