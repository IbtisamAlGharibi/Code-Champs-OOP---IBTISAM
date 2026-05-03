package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.University;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UniversityService {

    public static University university = universityInit();

    DepartmentService departmentService = new DepartmentService();
    StudentService studentService = new StudentService();
    TeacherService teacherService = new TeacherService();
    private List<Department> departments = new ArrayList<>();

    public static University universityInit() {
        University university = new University();
        university.setAddress("Oman");
        university.setId(UUID.randomUUID());
        university.setName("Oman University of Sciences");

        return university;

    }

    public Boolean handleUniversityMenu(Integer universityOption) {


        switch (universityOption) {
            case 1 -> {
                university.setDepartments(departmentService.addNewDepartments());
            }
            case 2 -> {
                System.out.println("Show Departments");
                university.displayDepartments();
            }
            case 3 -> {
                university.setStudentList(studentService.addNewStudents());
            }

            case 4 -> {
                university.setTeacherList(teacherService.addNewTeachers());
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }

}
