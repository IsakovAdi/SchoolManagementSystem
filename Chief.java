package OOP.SchoolManagementSystem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chief extends Employee {
    public Chief(int id, String name, String position, int salary) {
        super(id, name, position, salary);
    }

    public Chief(){}

    /**
     * из общего списка Employee выводим список объектов Chief
     *
     * @param school
     * @return
     */

    public static List<Chief> getChiefList(School school) {
        List<Chief> chiefList = new ArrayList<>();
        List<Employee> employeeList = school.getEmployeeList();
        for (Employee e : employeeList) {
            if (e instanceof Chief) {
                chiefList.add((Chief) e);
            }
        }
        return chiefList;
    }
//
//    /**
//     * getting information about the chosen person(employee)
//     *
//     * @param c
//     */
//
//    public static void getChiefInfo(Chief c) {
//        System.out.println("ID: " + c.getId() + " | Name: " + c.getName() + " | Position: " + c.getPosition()  + " | Salary: $" + c.getSalary());
//    }
//
//    /**
//     * choosing one Chief from the lots of chiefs in the Chief list
//     *
//     * @param school
//     * @param name
//     * @return
//     */
//    public static Chief getChosenChief(School school, String name) {
//        List<Chief> chiefList = getChiefList(school);
//        Chief chief = new Chief();
//        for (Chief c : chiefList) {
//            if (c.getName().equals(name)) {
//                chief = c;
//            }
//        }
//        return chief;
//    }

    /**
     * Creating information about Chiefs
     *
     * @param school
     */

    public static void getChiefsList(School school) {
        List<Chief> chiefList = getChiefList(school);
        for (Chief c : chiefList) {
            System.out.println("ID: " + c.getId()  + " | Name: " + c.getName()+ " | Position: " + c.getPosition() + " | Salary: $" + c.getSalary()+ " | Salary earned: $" + c.getSalaryEarned());
            System.out.println("-----------------------------------------------------------");
        }
    }

    public static void addNewChief(Scanner scanner, School school) {
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
                position = "chief";
            } else {
                System.out.println("Введите зарплату сотрудника...");
                salary = scanner.nextInt();
            }
        }
        System.out.println("Ваш сотрудник ");
        System.out.println("ID: " + id + " | name: " + name + " | position: " + position + " | salary $" + salary );

        Chief chief = new Chief(id, name, position, salary);
        school.addChief(chief);
    }
}
