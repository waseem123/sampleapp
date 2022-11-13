package com.learn.sampleapp.dto;

public class CitizenCenterDTO {
    private String citizenCenter;
    private Long citizenId;
    private String citizenName;
    private String citizenCity;
    private int citizenDoses;

    public CitizenCenterDTO(String citizenCenter, Long citizenId, String citizenName, String citizenCity, int citizenDoses) {
        this.citizenCenter = citizenCenter;
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenCity = citizenCity;
        this.citizenDoses = citizenDoses;
    }

    public String getCitizenCenter() {
        return citizenCenter;
    }

    public void setCitizenCenter(String citizenCenter) {
        this.citizenCenter = citizenCenter;
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

    public int getCitizenDoses() {
        return citizenDoses;
    }

    public void setCitizenDoses(int citizenDoses) {
        this.citizenDoses = citizenDoses;
    }
}
