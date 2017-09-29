package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestManager {

    private List<Guest> guestList;

    public GuestManager() {
        this.guestList = new ArrayList<>();
    }

    public void addGuest(Guest guest){
        this.guestList.add(guest);
    }
    public void deleteGuest(Guest guest){
        this.guestList.remove(guest);
    }

    public void modifyGuest(int guestId){
        for(Guest guest : guestList) {
            if(guest.getGuestNumber() == guestId) {

            }
        }
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

    public List<Guest> getGuestList() {
        return guestList;
    }


}
