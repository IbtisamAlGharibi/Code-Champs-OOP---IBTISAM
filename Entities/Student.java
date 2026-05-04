package ObjectOrientedProgramming.OOPDemo.Entities;


import ObjectOrientedProgramming.OOPDemo.Behaviours.StudentInterface;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person implements StudentInterface {


    private String registrationYear;

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    @Override
    public void registerCourse(Course course) {
        if (!(course.equals(null) && course.getId().equals(null))) {
            List<Course> tempCourseList = this.getCourseList();
            tempCourseList.add(course);
            this.setCourseList(tempCourseList);
            System.out.println(Constants.STUDENT_COURSE_REGISTERED);
        } else {
            System.out.println(Constants.STUDENT_COURSE_NOT_REGISTERED);
        }

    }

    @Override
    public void dropCourse(Integer courseIdToDrop) {
        List<Course> tempCourseList = this.getCourseList();

        for (Course c : tempCourseList) {
            if (c.getId().equals(courseIdToDrop)) {
                tempCourseList.remove(c);
            }
        }

        this.setCourseList(tempCourseList);
    }

    public String DisplayByName(){
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.DEPARTMENT_SEARCH_NAME);
        String searchName = scanner.nextLine();

        List<Student> studentsList = new ArrayList<>();
        for (int i =0; i<studentsList.size();i++){
            String targetName = String.valueOf(studentsList.get(i));
            if (searchName.equalsIgnoreCase(targetName)) {
                System.out.println("Student Id: " + student.getId());
                System.out.println("Student Name: " + student.getName());
            }
        }
        return searchName + " " + "Details are displayed";
    }

}
