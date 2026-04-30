package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static ObjectOrientedProgramming.OOPDemo.Services.UniversityService.university;

public class DepartmentService {

    CourseService courseService = new CourseService();

    public Department addNewDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Adding new department **");

        Department department = new Department();
        department.setId(UUID.randomUUID());

        System.out.println("Enter Department Name");
        String deptName = scanner.nextLine();
        department.setName(deptName);

        department.setOfferedCourses(courseService.addNewCourses());

        return department;
    }

    public List<Department> addNewDepartments() {
        Scanner scanner = new Scanner(System.in);
        List<Department> departmentList = new ArrayList<>();
        Boolean continueFlag = true;
        while (continueFlag) {
            //System.out.println("Entering multiple departments");
            departmentList.add(addNewDepartment());
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_DEPARTMENTS);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                continueFlag = false;
            }
        }
        return departmentList;
    }

    public String updateDepartment(){
        Department department = new Department();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.DEPARTMENT_UPDATE_NAME);
        String deptNameToUpdate = scanner.nextLine();
        department.setName(deptNameToUpdate);

        List<Department> departmentList = new ArrayList<>();
        System.out.println(Constants.DEPARTMENT_UPDATE_NEW_NAME);
        String newDeptName = scanner.nextLine();

       
        for (int i =0; i< departmentList.size()-1; i++){
            String oldDeptName = String.valueOf(departmentList.get(i));
            if (oldDeptName.equals(deptNameToUpdate) ){
                oldDeptName = newDeptName;
            }

        }
     return newDeptName;   
    }

    public String deleteDepartment(){
        Department department = new Department();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.DEPARTMENT_DELETE_NAME);
        String deptNameToDelete = scanner.nextLine();

        List<Department> departmentList = new ArrayList<>();

        for (int i =0; i< departmentList.size()-1; i++){
            String oldDeptName = String.valueOf(departmentList.get(i));
            if (oldDeptName.equals(deptNameToDelete) ){
                departmentList.remove(deptNameToDelete);
            }

        }
        return deptNameToDelete +" " + "DELETED";
    }

    public Boolean handleDepartmentMenu(Integer departmentOption) {
        DepartmentService departmentService = new DepartmentService();
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();

        switch (departmentOption) {
            case 1 -> {
                System.out.println("Add new department");
                departmentService.addNewDepartment();
            }
            case 2 -> {
                System.out.println("Updated department");
                departmentService.updateDepartment();
            }
            case 3 -> {
                System.out.println("Show Departments");
                university.displayDepartments();
            }

            case 4 -> {
                System.out.println("Delete department");
                departmentService.deleteDepartment();
            }

            case 5 -> {
                return false;
            }
        }
        return true;
    }
}


