package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Course;
import ObjectOrientedProgramming.OOPDemo.Entities.Teacher;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CourseService {

    public Course addNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new Course to the department **");

        Course course = new Course();
        course.setId(UUID.randomUUID());

        System.out.println("Enter course name");
        String courseName = scanner.nextLine();
        course.setName(courseName);

        System.out.println("Enter course code");
        String courseCode = scanner.nextLine();
        course.setCourseCode(courseCode);

        return course;

    }

    public List<Course> addNewCourses() {
        Scanner scanner = new Scanner(System.in);
        List<Course> courseList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            //System.out.println("Entering multiple courses");
            courseList.add(addNewCourse());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_COURSE);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }

        return courseList;


    }

    public String updateCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.COURSE_UPDATE_NAME);
        String courseNameToUpdate = scanner.nextLine();

        List<Course> courseList = new ArrayList<>();
        System.out.println(Constants.COURSE_UPDATE_New_NAME);
        String newCourseName = scanner.nextLine();

        for (int i =0; i< courseList.size()-1; i++){
            String oldCourseName = String.valueOf(courseList.get(i));
            if (oldCourseName.equals(courseNameToUpdate) ){
                oldCourseName = newCourseName;
            }
        }
        return newCourseName;
    }
}
