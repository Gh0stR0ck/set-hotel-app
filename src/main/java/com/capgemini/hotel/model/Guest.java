package com.capgemini.hotel.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Guest {

    @Id
    @Column(name = "guestNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guestNumber;
    @Length(max = 25, min = 1, message = "Surname must be between 1 and 25 characters.")
    private String surname;
    @Length(max = 25, min = 1, message = "Name must be between 1 and 25 characters.")
    private String name;
    @Length(max = 25, min = 1, message = "Address must be between 1 and 25 characters.")
    private String address;
    @Length(max = 15, min = 1, message = "Zipcode must be between 1 and 15 characters.")
    private String zipcode;
    @Length(max = 25, min = 1, message = "City must be between 1 and 25 characters.")
    private String city;
    @Length(max = 25, min = 1, message = "Country must be between 1 and 25 characters.")
    private String country;
    @Length(max = 18, min = 1, message = "Phone number must be between 1 and 18 numbers.")
    @Pattern(regexp="\\d+", message = "Phone number must only contain numbers.")
    private String phone;
    @Length(max = 50, min = 6, message = "E-mail must be at least 6 characters.")
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "E-mail is not a well-formed e-mail address.")
    private String email;


    public Guest() {
    }


    public long getGuestNumber() {
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
