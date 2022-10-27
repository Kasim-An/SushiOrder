package com.example.sushiorder.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sushi_order")
public class Sushi_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="status_id")
    private long status_id;
    @Column(name="sushi_id")
    private long sushi_id;
    @Column(name="createdAt")
    private Date createdtime;
    private Date stoptime;

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }

    public long getSushi_id() {
        return sushi_id;
    }

    public void setSushi_id(long sushi_id) {
        this.sushi_id = sushi_id;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }
}