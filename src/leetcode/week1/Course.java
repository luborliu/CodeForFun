package leetcode.week1;

import java.util.ArrayList;

public class Course {
	int id;
    ArrayList<Course> children;
    boolean isVisited;
    boolean isLabeled;
    public Course(int id) {
        this.id = id;
        this.isVisited = false;
        this.isLabeled = false;
        this.children = new ArrayList<Course>();
    }

}
