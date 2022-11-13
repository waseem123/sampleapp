package com.learn.sampleapp.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;
    private String citizenName;
    private String citizenCity;
    @Column(name = "vcenter_id",insertable = false,updatable = false)
    private int centerId;
    private int citizenDoses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vcenter_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private VaccinationCenter vaccinationCenter;

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public Citizen() {
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
//                ", centerId=" + centerId +
                ", citizenDoses=" + citizenDoses +
                '}';
    }
}
