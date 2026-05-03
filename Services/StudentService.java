package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.Student;
import ObjectOrientedProgramming.OOPDemo.Entities.University;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StudentService {
    CourseService courseService = new CourseService();
    DepartmentService departmentService = new DepartmentService();
    University university = new University();



    public Student addNewStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ** Adding new Student **");
        //object student class
        Student student = new Student();
        student.setId(UUID.randomUUID());

        System.out.println("Enter student Name: ");
        String stdName = scanner.nextLine();

        System.out.println("Departments List");
        UniversityService.university.displayDepartments();

        System.out.println("Enter Department: ");
        student.setDepartment(departmentService.addNewDepartment());

        student.setCourseList(student.getDepartment().getOfferedCourses());
     return student;
    }

    public List<Student> addNewStudents(){
        Scanner scanner = new Scanner(System.in);
        List<Student> studentsList = new ArrayList<>();

        Boolean continueFlag = true;
        while (continueFlag) {
            studentsList.add(addNewStudent());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_STUDENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return studentsList;
    }

    public String updateStudent(){
       Student student = new Student();
       Scanner scanner = new Scanner(System.in);
       System.out.println(Constants.STUDENT_UPDATE_NAME);
       String studentNameToUpdate = scanner.nextLine();

       List<Student> studentList = new ArrayList<>();
       System.out.println(Constants.STUDENT_UPDATE_New_NAME);
       String newStudentName = scanner.nextLine();


        for (int i =0; i< studentList.size()-1; i++){
            String oldStudentName = String.valueOf(studentList.get(i));
            if (oldStudentName.equals(studentNameToUpdate) ){
                oldStudentName = newStudentName;
            }
        }
        return newStudentName;
    }

    public String deleteStudent(){
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println(Constants.STUDENT_DELETE_NAME);
        String studentNameToDelete = scanner.nextLine();

        List<Student> studentList = new ArrayList<>();

        for (int i =0; i< studentList.size()-1; i++){
            String oldStudentName = String.valueOf(studentList.get(i));
            if (oldStudentName.equals(studentNameToDelete) ){
                studentList.remove(studentNameToDelete);
            }
        }
        return studentNameToDelete +" " + "DELETED";
    }

    public Boolean handleStudentMenu(Integer studentOption) {
        DepartmentService departmentService = new DepartmentService();
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();

        switch (studentOption) {
            case 1 -> {
                System.out.println("Add new student");
                studentService.addNewStudent();
            }
            case 2 -> {
                System.out.println("Updated Student");
               studentService.updateStudent();
            }
            case 3 -> {
                System.out.println("Show Students");
                university.displayStudents();
            }

            case 4 -> {
                System.out.println("Delete Student");
                studentService.deleteStudent();
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }
}

