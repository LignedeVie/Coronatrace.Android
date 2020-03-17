package com.trzas.coronatrace;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserLocation {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double latitude;
    private double longitude;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        return "UserLocation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", time=" + sdf.format(new Date(time)) +
                '}';
    }
}
