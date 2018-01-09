package com.example.lunarss.nycfreewifi;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This work is done by group 12.
 */

public class Process {
    Route[] primRoutes;

    /**
     * Process the data and get MST.
     * 
     * @param data - the given data
     * @param lat - the latitude of the point on the map
     * @param lon - the longitude of the point on the map
     */
    public Process(String[][] data, double lat, double lon) {

        SortSearch ss = new SortSearch();
        List<Point> pointList = ss.search(data, lat, lon);

        Point[] pointArr = new Point[pointList.size()];
        for (int i = 0; i < pointList.size(); i++) {
            pointArr[i] = pointList.get(i);
        }
        Route[][] adjRoute = new Route[pointArr.length][];
        List<Route> tmp = new ArrayList<Route>();
        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                tmp.add(new Route(pointArr[i], pointArr[j], ss.haversine(pointArr[i].getLat(), pointArr[i].getLon(), pointArr[j].getLat(), pointArr[j].getLon())));
            }
            Route[] TMP = new Route[tmp.size()];
            for (int j = 0; j < tmp.size(); j++) {
                TMP[j] = tmp.get(j);
            }
            adjRoute[i] = TMP;
        }

        LazyPrimMST prim = new LazyPrimMST(adjRoute, pointArr);
        primRoutes = prim.getPrimRoute();

    }

    /**
     * Get the primMST.
     * 
     * @return - the PrimMST.
     */
    public Route[] getPrim() {
        return this.primRoutes;
    }

}
