package com.example.sushiorder.entity;


import javax.persistence.*;

@Entity
@Table(name="sushi")
public class Sushi {
    @Id
    @Column
    private long id;
    @Column(name="name")
    private String Sushiname;
    @Column(name="time_to_make")
    private int timetomake;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSushiname() {
        return Sushiname;
    }

    public void setSushiname(String sushiname) {
        Sushiname = sushiname;
    }

    public int getTimetomake() {
        return timetomake;
    }

    public void setTimetomake(int timetomake) {
        this.timetomake = timetomake;
    }
}