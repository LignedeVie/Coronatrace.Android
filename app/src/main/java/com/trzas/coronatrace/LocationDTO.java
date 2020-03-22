package com.trzas.coronatrace;

import android.graphics.Point;

import java.util.Date;

public class LocationDTO {
    private Point location;
    private Date time;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
