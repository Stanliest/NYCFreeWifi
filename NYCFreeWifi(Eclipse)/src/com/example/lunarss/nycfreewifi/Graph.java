package com.example.lunarss.nycfreewifi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * This work is done by group 12.
 */

public class Graph {
    private HashMap<Point, TreeSet<Point>> adjList;
    private HashMap<Point, TreeSet<Route>> adjRoute;
    private HashMap<Double, Point> points;
    private HashMap<String, Route> routes;
    private int numPoints;
    private int numRoutes;

    /**
     * Constructor of the Graph.
     */
    public Graph() {
        adjList = new HashMap<Point, TreeSet<Point>>();
        adjRoute = new HashMap<Point, TreeSet<Route>>();
        points = new HashMap<Double, Point>();
        routes = new HashMap<String, Route>();
    }

    /**
     * Add a point to the graph.
     * 
     * @param lat - the latitude of the point
     * @param lon - the longitude of the point
     * @return - the added point
     */
    public Point addPoint(double lat, double lon) {
        Point c;
        c = points.get(lat + lon);
        if (c == null) {
            c = new Point(lat, lon);
            points.put(lat + lon, c);
            adjList.put(c, new TreeSet<Point>());
            adjRoute.put(c, new TreeSet<Route>());
            numPoints += 1;
        }
        return c;
    }

    /**
     * Detect whether a point is in the graph.
     * 
     * @param name - the name of the point
     * @return - the detected point
     */
    public boolean hasPoint(Double name) {
        return points.containsKey(name);
    }

    /**
     * Get the selected point.
     * 
     * @param name - the name of the point
     * @return - the selected point
     */
    public Point getPoint(Double name) {
        return points.get(name);
    }

    /**
     * Get all points in the graph.
     * 
     * @return - all points
     */
    public Point[] getPoints() {
        Point[] pointList = new Point[numPoints];
        Iterator<Point> tmp = points.values().iterator();
        for (int i = 0; i < numPoints; i++) {
            if (tmp.hasNext()) {
                pointList[i] = tmp.next();
            }
        }
        return pointList;
    }

    /**
     * Get the number of all points in the graph.
     * 
     * @return numpoints
     */
    public int numPoints() {
        return numPoints;
    }

}
