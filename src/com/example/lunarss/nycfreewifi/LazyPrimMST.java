package com.example.lunarss.nycfreewifi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This work is done by group 12.
 */

public class LazyPrimMST {
    private boolean[] marked; // MST vertices
    private MinPQ<Route> pq; // crossing (and ineligible) edges
    private List<Route> tmpRoute;
    private List<Route> primRoutes;

    /**
     * Constructor of LazyPrimMST.
     * 
     * @param adjRoutes - all adjacent routes of every point in the graph
     * @param points - all points in the graph
     */
    public LazyPrimMST(Route[][] adjRoutes, Point[] points) {
        pq = new MinPQ<Route>();
        marked = new boolean[points.length];
        tmpRoute = new ArrayList<Route>();
        primRoutes = new ArrayList<Route>();
        visit(0, adjRoutes, points); // assumes G is connected
        while (!pq.isEmpty()) {
            Route r = pq.delMin(); // Get lowest-weight
            int v = indexOf(points, r.first()), w = indexOf(points, r.second(points[v])); // edge
            // from
            // pq.
            if (marked[v] && marked[w]) {
                continue;
            } // Skip if ineligible.
            primRoutes.add(r);
            if (!marked[v]) {
                visit(v, adjRoutes, points);
            } // Add vertex to tree
            if (!marked[w]) {
                visit(w, adjRoutes, points);
            } // (either v or w).
        }
    }

    /**
     * Visit next level of points.
     * 
     * @param v - index of the current point
     * @param adjRoutes - all adjacent routes of every point in the graph
     * @param points - all points in the graph
     */
    private void visit(int v, Route[][] adjRoutes, Point[] points) {
        // Mark v and add to pq all edges from v to unmarked vertices.
        marked[v] = true;
        for (Route r : adjRoutes[v]) {
            if (!tmpRoute.contains(r)) { // !marked[indexOf(cities,
                pq.insert(r);
                tmpRoute.add(r);
            }
        }
    }

    /**
     * Get PrimMST.
     * 
     * @return - routes of minimum spanning tree
     */
    public Route[] getPrimRoute() {
        Route[] tmp = new Route[primRoutes.size()];
        for (int i = 0; i < primRoutes.size(); i++) {
            tmp[i] = primRoutes.get(i);
        }
        return tmp;
    }

    /**
     * Get index of a point from the point list.
     * 
     * @param points - the given point list
     * @param p - the given point
     * @return - the index of the point
     */
    public int indexOf(Point[] points, Point p) {
        for (int i = 0; i < points.length; i++) {
            if (points[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }
}
