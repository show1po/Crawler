package com.tn.web.po;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Show on 2016/10/24.
 */
@Entity
public class PositionMapping {
    public PositionMapping(){
        
    }
    public PositionMapping(Double lng, Double lat, String address, String place_id, Date datetime, User user) {
        this.lng = lng;
        this.lat = lat;
        this.address = address;
        this.place_id = place_id;
        this.datetime = datetime;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double lng;
    private Double lat;
    private String address;
    private String place_id;
    private Date datetime;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }
}
