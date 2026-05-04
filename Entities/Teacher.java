package ObjectOrientedProgramming.OOPDemo.Entities;

import ObjectOrientedProgramming.OOPDemo.Behaviours.TeacherInterface;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;
import ObjectOrientedProgramming.OOPDemo.Utils.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Person implements TeacherInterface {

    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void assignCourse(Course courseToAssign) {
        if (Helper.isNotNull(courseToAssign)) {
            List<Course> tempCourseList = this.getCourseList();
            tempCourseList.add(courseToAssign);
            this.setCourseList(tempCourseList);
            System.out.println(Constants.TEACHER_COURSE_ASSIGNED);
        } else {
            System.out.println(Constants.TEACHER_NOT_COURSE_ASSIGNED);
        }
    }

    public String DisplayByName(){
       Teacher teacher = new Teacher();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.TEACHER_SEARCH_NAME);
        String searchName = scanner.nextLine();

        List<Teacher> TeacherList = new ArrayList<>();
        for (int i =0; i<TeacherList.size();i++){
            String targetName = String.valueOf(TeacherList.get(i));
            if (searchName.equalsIgnoreCase(targetName)) {
                System.out.println("Teacher Id: " + teacher.getId());
                System.out.println("Teacher Name: " + teacher.getName());
            }
        }
        return searchName + " " + "Details are displayed";
    }
}
