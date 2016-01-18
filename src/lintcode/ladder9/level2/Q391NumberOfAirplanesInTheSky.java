package lintcode.ladder9.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q391NumberOfAirplanesInTheSky {
	
	/**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // the point here is to use scan-line strategy
        // and override compare function in Comparator class
        // need to be carefull when there are collisions at the same time (plane takes off and lands on at the same time)
        
        List<Point> pList = new ArrayList<Point>();
        for(Interval i: airplanes) {
            pList.add(new Point(i.start,true));
            pList.add(new Point(i.end, false));
        }
        
        
        
        Collections.sort(pList, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if(p1.time!=p2.time) return p1.time-p2.time;
                else if(!p1.status) {
                    return -1;
                } else if(!p2.status) {
                    return 1;
                } else return 0;
            }
        } );
        
        int count = 0;
        int maxCount = 0;
        
        for(Point p: pList) {
            if(p.status) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count--;
            }
        }
        
        return maxCount;
        
    }
    
    class Interval {
    	int start, end;
    	Interval(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    }
    
    class Point {
        int time = 0;
        boolean status = true; //true = start, false end 
        public Point(int time, boolean status) {
            this.time = time;
            this.status = status;
        }
    }

}
