package com.example.lunarss.nycfreewifi;

/**
 * This work is done by group 12.
 */

public class Route implements Comparable<Route> {
    private final Point first;
    private final Point second;
    private final double weight;

    /**
     * Constructor of the Route.
     * 
     * @param a - the start point
     * @param b - the end point
     * @param length - the route's length
     */
    public Route(Point a, Point b, double length) {
        this.first = a;
        this.second = b;
        this.weight = length;
    }

    /**
     * Get the first point.
     * 
     * @return - the first point
     */
    public Point first() {
        return this.first;
    }

    /**
     * Get another point.
     * 
     * @param first - the first point
     * @return - the either point
     */
    public Point second(Point first) {
        if (first.equals(this.first)) {
            return this.second;
        } else if (first.equals(this.second)) {
            return this.first;
        } else {
            throw new IllegalArgumentException("Illegal city");
        }
    }


    /**
     * Get the length of the route.
     * 
     * @return - the length
     */
    public double getLength() {
        return this.weight;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Route that) {
        return Double.compare(this.weight, that.weight);
    }

}
