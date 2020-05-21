package OOP.SchoolManagementSystem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Janitor extends Employee {
    public Janitor(int id, String name, String position, int salary) {
        super(id, name, position, salary);
    }

    public Janitor(){}

    /**
     * из общего списка Employee выводим список объектов Janitor
     *
     * @param school
     * @return
     */

    public static List<Janitor> getJanitorList(School school) {
        List<Janitor> janitorList = new ArrayList<>();
        List<Employee> employeeList = school.getEmployeeList();
        for (Employee e : employeeList) {
            if (e instanceof Janitor) {
                janitorList.add((Janitor) e);
            }
        }
        return janitorList;
    }

//    /**
//     * getting information about the chosen person(employee)
//     *
//     * @param j
//     */
//
//    public static void getJanitorInfo(Janitor j) {
//        System.out.println("ID: " + j.getId()+ " | Name: " + j.getName() + " | Position: " + j.getPosition()  + " | Salary: $" + j.getSalary());
//    }
//
//    /**
//     * choosing one Chief from the lots of chiefs in the Chief list
//     *
//     * @param school
//     * @param name
//     * @return
//     */
//    public static Janitor getChosenJanitor(School school, String name) {
//        List<Janitor> janitorList = getJanitorList(school);
//        Janitor janitor = new Janitor();
//        for (Janitor j : janitorList) {
//            if (j.getName().equals(name)) {
//                janitor = j;
//            }
//        }
//        return janitor;
//    }

    /**
     * Creating information about Janitors
     *
     * @param school
     */

    public static void getJanitorsList(School school) {
        List<Janitor> janitorList = getJanitorList(school);
        for (Janitor c : janitorList) {
            System.out.println("ID: " + c.getId() + " | Name: " + c.getName()+ " | Position: " + c.getPosition()  + " | Salary: $" + c.getSalary()+ " | Salary earned: $" + c.getSalaryEarned());
            System.out.println("-----------------------------------------------------------");
        }
    }
    public static void addNewJanitor(Scanner scanner, School school) {
        int id = 0;
        String name = null;
        String position = null;
        int salary = 0;

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                id = GenID.genUniqueId();
            } else if (i == 1) {
                System.out.println("Введите имя сотрудника...");
                name = scanner.next();
            } else if (i == 2) {
                position = "janitor";
            } else {
                System.out.println("Введите зарплату сотрудника...");
                salary = scanner.nextInt();
            }
        }
        System.out.println("Ваш сотрудник ");
        System.out.println("ID: " + id + " | name: " + name + " | position: " + position + " | salary $" + salary );

        Janitor janitor = new Janitor(id, name, position, salary);
        school.addJanitor(janitor);
    }
}
