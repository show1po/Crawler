package com.tn.web.responses;

import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2016/10/24.
 */
public class PositionInfoResp {
    private Double lng;
    private Double lat;
    private String address;
    private String placeId;
    private String dateTime;
    private String userName;
    private List latlng;
    private boolean display;

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public List getLatlng(){return latlng;}

    public void setLatlng(List latlng){
        this.latlng=latlng;
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

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
