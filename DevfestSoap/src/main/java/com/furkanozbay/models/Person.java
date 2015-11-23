package com.furkanozbay.models;


/**
 * Created by Furkan on 19.11.2015.
 */

public class Person {

    private String name, surname;
    private double telephoneNumber;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(double telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }



}
