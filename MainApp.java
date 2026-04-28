package ObjectOrientedProgramming.OOPDemo;

import ObjectOrientedProgramming.OOPDemo.Menu.Menu;
import ObjectOrientedProgramming.OOPDemo.Utils.MenuMessages;

import java.util.Scanner;

public class MainApp {
    static Menu menu = new Menu();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu.displayMenu();
        Integer option = input.nextInt();
        switch (option) {
            case 1 -> {
                System.out.println("University Menu");
                System.out.println(MenuMessages.UNIVERSITY_MENU_MESSAGE);
                Integer universityOption = input.nextInt();

            }
            case 2 -> System.out.println("Department Menu");
            case 3 -> System.out.println("Teacher Menu");
            case 4 -> System.out.println("Student Menu");
            case 5 -> System.out.println("Course Menu");
            case 6 -> System.out.println("Exit");
            default -> System.out.println("Select a choice from the list");
        }

    }
}
