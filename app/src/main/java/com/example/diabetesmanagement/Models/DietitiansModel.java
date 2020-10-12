package com.example.diabetesmanagement.Models;

public class DietitiansModel {
    String id,names,email,contact,location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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

    public DietitiansModel(String id, String names, String email, String contact, String location) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.contact = contact;
        this.location = location;
    }
}
