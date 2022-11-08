package com.learn.sampleapp.model;

import javax.persistence.*;

@Entity
public class CenterMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int userId;
    private int centerId;

    public CenterMapping() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public CenterMapping(Long id, int userId, int centerId) {
        this.id = id;
        this.userId = userId;
        this.centerId = centerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CenterMapping{" +
                "id=" + id +
                ", userId=" + userId +
                ", centerId=" + centerId +
                '}';
    }
}
