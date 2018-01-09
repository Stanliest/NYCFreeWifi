package com.example.lunarss.nycfreewifi;


import java.io.*;
import java.util.*;

/**
 * This work is done by group 12.
 */

public class Point {
    private double lat;
    private double lon;
    public double name;


    /**
     * Constructor of the Point.
     * 
     * @param lat - the latitude of the point
     * @param lon - the longitude of the point
     */
    public Point(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        this.name = lat+lon;
    }

    /**
     * Get the latitude of the point.
     * 
     * @return - the latitude
     */
    public double getLat() {
        return this.lat;
    }

    /**
     * Get the longitude of the point.
     * 
     * @return - the longitude
     */
    public double getLon() {
        return this.lon;
    }

    /**
     * Compare two given points.
     * 
     * @param o - another point
     * @return - the result of comparison
     */
    public boolean equals(Point o) {
        if (this.lat == o.getLat() && this.lon == o.getLon()) {
            return true;
        }
        return false;
    }
}




