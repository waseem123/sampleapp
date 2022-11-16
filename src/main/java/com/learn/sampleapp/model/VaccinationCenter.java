package com.learn.sampleapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int centerId;
    private String centerName;
    private String centerCity;

    @OneToMany(targetEntity = Citizen.class, cascade = CascadeType.ALL, mappedBy = "vaccinationCenter")
//    @JoinColumn(name = "vcenter_id")
    private List<Citizen> citizens = new ArrayList<>();


    public VaccinationCenter() {
    }

    public VaccinationCenter(String centerName, String centerCity) {
        this.centerName = centerName;
        this.centerCity = centerCity;
    }

    public VaccinationCenter(int centerId, String centerName, String centerCity) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.centerCity = centerCity;
    }

    public VaccinationCenter(int centerId) {
        this.centerId = centerId;
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

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
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
