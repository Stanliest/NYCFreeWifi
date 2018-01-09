package com.example.lunarss.nycfreewifi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LunarSS on 2017/4/3.
 */

public class SortSearch {
    private static final int SIZE = 5;//2061;
    private static final double R = 6372.8;

    /**
     *Constructor of the SortSearch. 
     */
    public SortSearch() {
    }

    /**
     * Compare two Strings.
     * 
     * @param v - the first string
     * @param w - the second string
     * @return - the result of comparison
     */
    public static boolean less(String v, String w) {
        return Double.parseDouble(v) < Double.parseDouble(w);
    }

    /**
     * Exchange two elements' positions in the given list
     * 
     * @param a - the given list
     * @param i - the first index
     * @param j - the second index
     */
    private static void exch(String[][] a, int i, int j) {
        String[] t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Detect if the list is sorted
     * 
     * @param a - the given list 
     * @return - the result of detection
     */
    public static boolean isSorted(String[][] a) { // Test whether the array
        // entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i][1], a[i - 1][1])) // 2 is the position of latitude in
                // array
                return false;
        return true;
    }

    /**
     * Sort the given list.
     * 
     * @param a - the given list
     */
    public static void sort(String[][] a) { // Sort a[] into increasing
        // order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++) { // Exchange a[i] with smallest entry in
            // a[i+1...N).
            for(int j = i ; j > 0 && less(a[j][1],a[j-1][1]) ;j--){
                exch(a, j, j-1);
            }
        }
    }

    /**
     * Search some Points in the given list.
     * 
     * @param list - the given list
     * @param lat - the latitude of the point
     * @param lon - the longitude of the point
     * @return - the searched point list
     */
    public static List<Point> search(String[][] list, double lat, double lon) {
        double r = 200;
        Point source = new Point(lat, lon);
        List<Point> pointList = new ArrayList<Point>();
        for (int i = 0; i < SIZE; i++) {
            Point q = new Point(Double.parseDouble(list[i][1]), Double.parseDouble(list[i][2]));
            if (haversine(source.getLat(), source.getLon(), q.getLat(), q.getLon()) < r) {
                pointList.add(q);
            }
        }
        return pointList;
    }

    /**
     * Get the distance of two given points.
     * 
     * @param lat1 - the latitude of the first point
     * @param lon1 - the longitude of the first point
     * @param lat2 - the latitude of the second point
     * @param lon2 - the longitude of the second point
     * @return - the distance
     */
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        Point p2 = new Point(lat2, lon2);
        Point p1 = new Point(lat1, lon1);
        double dLat = Math.toRadians(p2.getLat() - p1.getLat());
        double dLon = Math.toRadians(p2.getLon() - p1.getLon());
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c * 1000;
    }
    

}
