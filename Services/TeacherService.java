package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Person;
import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Entities.Teacher;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TeacherService {

    static Integer counter = 1;
    PersonService personService = new PersonService();
    DepartmentService departmentService = new DepartmentService();
    CourseService courseService = new CourseService();
    University university = new University();
    Teacher teacher = new Teacher();

    public Teacher addNewTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new teacher **");

        Teacher teacher = (Teacher) personService.addNewPerson();
        /*teacher.setId(UUID.randomUUID());

        System.out.println("Enter Name");
        String teacherName = scanner.nextLine();
        teacher.setName(teacherName);

        System.out.println("Enter Email");
        String teacherEmail = scanner.nextLine();
        teacher.setEmail(teacherEmail);

        System.out.println("Enter Phone Number");*/

        teacher.setTeacherId("TH-" + counter);
        counter += 1;

        System.out.println("Departments & Associated Courses: ");
        UniversityService.university.displayDepartments();

        teacher.setDepartment(departmentService.addNewDepartment());

        teacher.setCourseList(courseService.addNewCourses());

        return teacher;
    }

    public List<Teacher> addNewTeachers() {
        Scanner scanner = new Scanner(System.in);
        List<Teacher> teacherList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            teacherList.add(addNewTeacher());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_TEACHER);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return teacherList;
    }

    public String updateTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.TEACHER_UPDATE_NAME);
        String teacherNameToUpdate = scanner.nextLine();

        List<Teacher> teacherList = new ArrayList<>();
        System.out.println(Constants.TEACHER_UPDATE_New_NAME);
        String newTeacherName = scanner.nextLine();

        for (int i =0; i< teacherList.size()-1; i++){
            String oldTeacherName = String.valueOf(teacherList.get(i));
            if (oldTeacherName.equals(teacherNameToUpdate) ){
                oldTeacherName = newTeacherName;
            }
        }
        return newTeacherName;
    }

    public String deleteTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.TEACHER_DELETE_NAME);
        String teacherNameToDelete = scanner.nextLine();

        List<Teacher> TeacherList = new ArrayList<>();

        for (int i =0; i< TeacherList.size()-1; i++){
            String oldTeacherName = String.valueOf(TeacherList.get(i));
            if (oldTeacherName.equals(teacherNameToDelete) ){
                TeacherList.remove(teacherNameToDelete);
            }
        }
        return teacherNameToDelete +" " + "DELETED";

    }

    public Boolean handleTeacherMenu(Integer teacherOption) {
        DepartmentService departmentService = new DepartmentService();
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();

        switch (teacherOption) {
            case 1 -> {
                System.out.println("Add new teacher");
                teacherService.addNewTeacher();
            }
            case 2 -> {
                System.out.println("Updated Teacher");
                teacherService.updateTeacher();
            }
            case 3 -> {
                System.out.println("Show Teachers");
                university.displayTeachers();
                System.out.println("Search by Teacher name");
                teacher.DisplayByName();
            }

            case 4 -> {
                System.out.println("Delete Teacher");
                teacherService.deleteTeacher();
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }

}
