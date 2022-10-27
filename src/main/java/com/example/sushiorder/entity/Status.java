package com.example.sushiorder.entity;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {
    @Id
    @Column
    private long id;
    @Column(name="name")
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}