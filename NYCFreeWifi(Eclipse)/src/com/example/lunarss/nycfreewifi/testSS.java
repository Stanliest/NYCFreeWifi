package com.example.lunarss.nycfreewifi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class testSS {

	@Test
	public void testsort() {
		String[][] a = {{"1","15","3"},{"4","5","6"},{"7","9","9"},{"7","10","9"}};
		SortSearch.sort(a);
		//System.out.println(Arrays.deepToString(a));
		assertTrue(SortSearch.isSorted(a));
	}

	@Test
	public void testsortequal() {
		String[][] a = {{"1","15","3"},{"4","15","6"},{"7","15","9"},{"7","15","9"}};
		SortSearch.sort(a);
		//System.out.println(Arrays.deepToString(a));
		assertTrue(SortSearch.isSorted(a));
}
	@Test
	public void testpointlat() {
		Point p = new Point(1,2);
		assertTrue(p.getLat() == 1);
	}
	
	@Test
	public void testpointlon() {
		Point p = new Point(1,2);
		assertTrue(p.getLon() == 2);
	}
	
	@Test
	public void testpointequal() {
		Point p = new Point(1,2);
		Point p2 = new Point(1,2);
		assertTrue(p.equals(p2));
	}
	@Test
	public void testgraphhas() {
		Graph G = new Graph();
		G.addPoint(1.0, 2.0);
		G.addPoint(2.0, 3.0);
		assertTrue(G.hasPoint(5.0));		
	}
	
	@Test
	public void testgraphget() {
		Graph G = new Graph();
		Point a = new Point(2.0, 3.0);
		G.addPoint(1.0, 2.0);
		G.addPoint(2.0, 3.0);
		assertTrue(G.getPoint(5.0).equals(a));		
	}
	
	@Test
	public void testsearch() {
		String[][] a = {{"1","15","3"},{"4","15","6"},{"7","15","9"},{"7","15","9"}};
		assertTrue(SortSearch.haversine(15, 3, 15, 6) - 322306.72360411077 < 0.0000000000001);
	}
	

	


}
