package com.capgemini.hotel.model;

import javax.persistence.*;

@Entity
public class Guest {

    @Id
    @Column(name = "guestNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int guestNumber;
    private String surname;
    private String name;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String phone;
    private String email;

    public Guest() {
        // JSON spring boot purpose
    }


    public int getGuestNumber() {
        return guestNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Guest[id=%d, name='%s', surname='%s']",
                guestNumber, name, surname);
    }
}
