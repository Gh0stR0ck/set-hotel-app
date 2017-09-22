package com.capgemini.hotel.core;

import java.util.List;
import java.util.stream.Collectors;

public class RoomManager {

    private List<Room> roomList;
    private List<Reservation> reservationList;
    private List<Guest> guestList;

    public List<Room> getRoomList() {
        return roomList;
    }

    private List<Guest> searchGuest(Integer guestNumber, String surname, String firstname, String adress, String zipcode, String city, String country){
        return guestList.stream()
                .filter(guestNumber == null ?
                        (g -> true) :
                        (g -> g.getGuestNumber() == guestNumber))
                .filter(surname == null ?
                        (g -> true) :
                        (g -> g.getSurname().toLowerCase().contains(surname.toLowerCase())))
                .filter(firstname == null ?
                        (g -> true) :
                        (g -> g.getName().toLowerCase().contains(firstname.toLowerCase())))
                .filter(adress == null ?
                        (g -> true) :
                        (g -> g.getAddress().toLowerCase().contains(adress.toLowerCase())))
                .filter(zipcode == null ?
                        (g -> true) :
                        (g -> g.getZipcode().toLowerCase().contains(zipcode.toLowerCase())))
                .filter(city == null ?
                        (g -> true) :
                        (g -> g.getCity().toLowerCase().contains(city.toLowerCase())))
                .filter(country == null ?
                        (g -> true) :
                        (g -> g.getCountry().toLowerCase().contains(country.toLowerCase())))
                .collect(Collectors.toList());

    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

}
