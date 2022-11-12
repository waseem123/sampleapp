package com.learn.sampleapp.model;

import javax.persistence.*;

@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long citizenId;
    String citizenName;
    String citizenCity;
    @Column(name = "center_id")
    int centerId;
    int citizenDoses;

    public Citizen() {
    }

    public Citizen(String citizenName, String citizenCity, int centerId, int citizenDoses) {
        this.citizenName = citizenName;
        this.citizenCity = citizenCity;
        this.centerId = centerId;
        this.citizenDoses = citizenDoses;
    }

    public Citizen(Long citizenId, String citizenName, String citizenCity, int centerId, int citizenDoses) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenCity = citizenCity;
        this.centerId = centerId;
        this.citizenDoses = citizenDoses;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getCitizenCity() {
        return citizenCity;
    }

    public void setCitizenCity(String citizenCity) {
        this.citizenCity = citizenCity;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getCitizenDoses() {
        return citizenDoses;
    }

    public void setCitizenDoses(int citizenDoses) {
        this.citizenDoses = citizenDoses;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", citizenName='" + citizenName + '\'' +
                ", citizenCity='" + citizenCity + '\'' +
                ", centerId=" + centerId +
                ", citizenDoses=" + citizenDoses +
                '}';
    }
}
