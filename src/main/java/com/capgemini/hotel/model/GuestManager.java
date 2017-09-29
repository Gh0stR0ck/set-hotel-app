package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GuestManager {

    // Fields
    private List<Guest> guestList;

    // Constructor
    public GuestManager() {
        this.guestList = new ArrayList<>();
    }

    // ----------
    // Methods
    // ---------

    // delete a guest from guestlist
    public void deleteGuest(Guest guest){
        this.guestList.remove(guest);
    }
    
    // add guest to guestlist
    public void addGuest(Guest guest){

        if(guest == null){
            return;
            // Case of inserting a null object in method.
        }

        Guest foundGuest = null;

        for(Guest currentGuest : guestList) {
            if(currentGuest.getGuestNumber() == guest.getGuestNumber()) {
                foundGuest = currentGuest;
                break;
            }
        }

        if(foundGuest != null){
            // Remove and than add to 'modify' guest
            guestList.remove(foundGuest);
        }
        // add new guest
        guestList.add(guest);


    }

    // return list based on search criteria
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


    // return the entire guestlist.
    public List<Guest> getGuestList() {
        return Collections.unmodifiableList(guestList);
    }


    // return a guest based on ID.
    public Guest getGuest(int guestId){

        for(Guest guest: guestList){
            if(guest.getGuestNumber() == guestId){
                return guest;
            }
        }
        return null;
    }
}
