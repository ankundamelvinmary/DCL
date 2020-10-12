package com.example.diabetesmanagement.Models;

public class PhysiothelapistsModel {
    String id,fullnames,email,contact,location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PhysiothelapistsModel(String id, String fullnames, String email, String contact, String location) {
        this.id = id;
        this.fullnames = fullnames;
        this.email = email;
        this.contact = contact;
        this.location = location;
    }
}
