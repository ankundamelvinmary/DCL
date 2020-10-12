package com.example.diabetesmanagement.Models;

public class PatientsModel {
    String id,name,age,district,occupation,glucose,bmi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public PatientsModel(String id, String name, String age, String district, String occupation, String glucose, String bmi) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.district = district;
        this.occupation = occupation;
        this.glucose = glucose;
        this.bmi = bmi;
    }
}
