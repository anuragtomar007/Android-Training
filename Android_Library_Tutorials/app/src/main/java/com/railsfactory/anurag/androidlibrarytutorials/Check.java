package com.railsfactory.anurag.androidlibrarytutorials;

import com.google.gson.annotations.SerializedName;

public class Check {
    private String id;
    private String bay;
    @SerializedName("LotId")
    private String lotId;
    @SerializedName("SensorId")
    private String sensorId;
    private String lat;
    private String longi;
    private String avail;
    private String timeStamp;

    public Check(String id, String bay, String lotId, String sensorId, String lat, String longi, String avail, String timeStamp) {
        this.id = id;
        this.bay = bay;
        this.lotId = lotId;
        this.sensorId = sensorId;
        this.lat = lat;
        this.longi = longi;
        this.avail = avail;
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    public String getBay() {
        return bay;
    }

    public String getLotId() {
        return lotId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getLat() {
        return lat;
    }

    public String getLongi() {
        return longi;
    }

    public String getAvail() {
        return avail;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
