package com.learn.sampleapp.model;

import javax.persistence.*;

@Entity
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int centerId;
    String centerName;
    String centerCity;

    public VaccinationCenter() {
    }

    public VaccinationCenter(String centerName, String centerCity) {
        this.centerName = centerName;
        this.centerCity = centerCity;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCity() {
        return centerCity;
    }

    public void setCenterCity(String centerCity) {
        this.centerCity = centerCity;
    }

    @Override
    public String toString() {
        return "VaccinationCenter{" +
                "centerId=" + centerId +
                ", centerName=" + centerName +
                ", centerCity=" + centerCity +
                '}';
    }
}
