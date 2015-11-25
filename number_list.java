package com.rail.injilaislam.railways;

public class Number_list {
    String day, resp,code;
    Double latitude;
    Double longitude;
    String arrival, departure;
    String name, state;

    public void set_list(String day, Double lat, Double lng, String arr, String dept, String name, String state, String code) {
        this.day = day;
        this.latitude = lat;
        this.longitude = lng;
        this.arrival = arr;
        this.departure = dept;
        this.name = name;
        this.state = state;
        this.resp = "200";
        this.code = code;
    }
    public void setResponse(String response){
        this.resp = response;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDay() {
        return day;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getResp() {
        return resp;
    }

    public String getCode() {
        return code;
    }
}
