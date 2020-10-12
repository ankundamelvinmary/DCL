package com.example.diabetesmanagement.Models;

public class DoctorsModel {
    String id,name,age,sex,contact,email,district,hospital;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return name;
    }

    public void setFirstname(String firstname) {
        this.name = firstname;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public DoctorsModel(String id, String name,  String age, String sex, String contact, String email, String district, String hospital) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.contact = contact;
        this.email = email;
        this.district = district;
        this.hospital = hospital;
    }
}
