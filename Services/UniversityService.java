package ObjectOrientedProgramming.OOPDemo.Services;

import ObjectOrientedProgramming.OOPDemo.Entities.Department;
import ObjectOrientedProgramming.OOPDemo.Entities.University;

public class UniversityService {

    public static University universityInit() {
        University university = new University();
        university.setAddress("Oman");
        university.setId(1);
        university.setName("Oman University of Sciences");

        return university;

    }

    public void handleUniversityMenu(Integer universityOption) {

        University university = new University();
        switch (universityOption) {
            case 1 -> {
                System.out.println("Show Departments");
                university.displayDepartments();
            }
        }
    }
}
