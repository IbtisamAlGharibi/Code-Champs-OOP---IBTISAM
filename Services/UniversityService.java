package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.University;

import java.util.UUID;

public class UniversityService {

    DepartmentService departmentService = new DepartmentService();

    public static University universityInit() {
        University university = new University();
        university.setAddress("Oman");
        university.setId(UUID.randomUUID());
        university.setName("Oman University of Sciences");

        return university;

    }

    public void handleUniversityMenu(Integer universityOption) {

        University university = universityInit();
        switch (universityOption) {
            case 1 -> {
                System.out.println("Input department");
                university.setDepartments(departmentService.addNewDepartments());
            }
            case 2 -> {
                System.out.println("Show Departments");
                university.displayDepartments();
            }
        }
    }
}
