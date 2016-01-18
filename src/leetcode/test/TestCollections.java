package leetcode.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TestCollections {
	
	class Point {
		int time = 0;
        boolean status = true; //true = start, false end 
        public Point(int time, boolean status) {
            this.time = time;
            this.status = status;
        }
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayList<Point> x = new ArrayList<Point>();
		
		Collections.sort(x, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				int time1 = p1.time;
				int time2 = p2.time;
				return time1-time2;
			}
		});
	}

}
