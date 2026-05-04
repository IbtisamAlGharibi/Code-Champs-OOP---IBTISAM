package ObjectOrientedProgramming.OOPDemo.Entities;

import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course extends ParentEntity {

    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                '}';
    }

    public String DisplayByName(){
        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.COURSE_SEARCH_NAME);
        String searchName = scanner.nextLine();

        List<Course> courseList = new ArrayList<>();
        for (int i =0; i<courseList.size();i++){
            String targetName = String.valueOf(courseList.get(i));
            if (searchName.equalsIgnoreCase(targetName)) {
                System.out.println("Course Id: " + course.getId());
                System.out.println("Course Name: " + course.getName());
                System.out.println("Course Code: " + course.getCourseCode());
            }
        }
        return searchName + " " + "Details are displayed";
    }
}
