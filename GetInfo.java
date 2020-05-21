package OOP.SchoolManagementSystem2;

import java.util.Scanner;

public class GetInfo {
    public static void mainMenu(School school, Scanner scanner) {
        System.out.println("Welcome to the School management System");
        while (true) {
            System.out.println("Main Menu");
            System.out.println("Choose an option, please");
            System.out.println("1. Information about school");
            System.out.println("2. Browse employees");
            System.out.println("3. Browse student");
            System.out.println("4. Make payment");
            System.out.println("5. Add new employee");
            System.out.println("6. Add new student");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    getSchoolInfo(school);
                    break;
                case 2:
                    EmployeeList(school, scanner);
                    break;
                case 3:
                    Student.getStudentsList(school);
                    break;
                case 4:
                    finance(school, scanner);
                    break;
                case 5:
                    System.out.println("Please, choose who do you want to add.");
                    System.out.println("1.Teacher   |   2.Chief   |   3.Janitor");
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1:
                            Teacher.addNewTeacher(scanner, school);
                            break;
                        case 2:
                            Chief.addNewChief(scanner, school);
                            break;
                        case 3:
                            Janitor.addNewJanitor(scanner, school);
                    }
                    break;
                case 6:
                    Student.addNewStudent(school,scanner);
                    break;
                case 7:
                    System.out.println("Quitting...........");
                    System.exit(0);
            }
        }
    }

    /**
     * Creating Shool information
     *
     * @param school
     */
    public static void getSchoolInfo(School school) {
        System.out.println("Information about school " + school.getSchoolName());
        System.out.println("-----------------------------------------------------------");
        System.out.println("School has " + school.getStudentList().size() + " students");
        System.out.println("School has " + Teacher.getTeacherList(school).size() + " teachers");
        System.out.println("School has " + Chief.getChiefList(school).size() + " chiefs");
        System.out.println("School has " + Janitor.getJanitorList(school).size() + " janitors");
        System.out.println("School has earned $" + school.getTotalMoneyEarned());
        System.out.println("School has spent $" + school.getTotalMoneySpent());
        System.out.println("-----------------------------------------------------------");
    }

    /**
     * Creating School's employees section
     *
     * @param school
     * @param scanner
     */
    public static void EmployeeList(School school, Scanner scanner) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("You are in a section " + school.getSchoolName() + " school's employees");
        while (true) {
            System.out.println("Please, choose an option");
            System.out.println("1. See all employees");
            System.out.println("2. See all teachers");
            System.out.println("3. See all chiefs");
            System.out.println("4. See all janitors");
            System.out.println("5. Get information about one employee");
            System.out.println("6. Main menu");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(school.getSchoolName() + "'s all Employees");
                    Employee.getEmployeesList(school);
                    break;
                case 2:
                    System.out.println(school.getSchoolName() + "'s all Teachers");
                    Teacher.getTeachersList(school);
                    break;
                case 3:
                    System.out.println(school.getSchoolName() + "'s all Chiefs");
                    Chief.getChiefsList(school);
                    break;
                case 4:
                    System.out.println(school.getSchoolName() + "'s all Janitors");
                    Janitor.getJanitorsList(school);
                    break;
                case 5:
                    Employee.getEmployeeInformation(school, scanner);
                    break;
                case 6:
                    mainMenu(school, scanner);
                    break;
                case 7:
                    System.out.println("Quitting...........");
                    System.exit(0);
            }
        }
    }

    /**
     * Creating financial operations
     *
     * @param school
     * @param scanner
     */
    public static void finance(School school, Scanner scanner) {
        System.out.println("School finance department");
        System.out.println("Choose an option, please");
        System.out.println("1. Get fee from students");
        System.out.println("2. Pay salary for employees");
        System.out.println("3. Main menu");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Student.payFees(school, scanner);
            case 2:
                payForEmployees(school, scanner);
                break;
            case 3:
                mainMenu(school, scanner);
                break;
            case 4:
                System.out.println("Quitting...........");
                System.exit(0);
        }
    }

    /**
     * Creating financial operations for employees
     *
     * @param school
     * @param scanner
     */
    public static void payForEmployees(School school, Scanner scanner) {
        System.out.println("You are in a pay salary section");
        System.out.println("Please, choose an option");
        System.out.println("1. Pay salary for all employees");
        System.out.println("2. Pay salary for one employee");
        System.out.println("3. Go to the payment section");
        System.out.println("4. Main menu");
        System.out.println("5. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1://///////////////////////////////////////////
                Employee.payForAllEmployees(school, scanner);
            case 2:
                Employee.makePayment(school, scanner);
            case 3:
                finance(school, scanner);
            case 4:
                mainMenu(school, scanner);
                break;
            case 5:
                System.out.println("Quitting...........");
                System.exit(0);
        }
    }
}
