package OOP.SchoolManagementSystem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Employee {

    public Teacher(int id, String name, String position, int salary) {
        super(id, name, position, salary);
    }

    public Teacher() {
    }


    /**
     * из общего списка Employee выводим список объектов Teacher
     *
     * @param school
     * @return
     */

    public static List<Teacher> getTeacherList(School school) {
        List<Teacher> teacherList = new ArrayList<>();
        List<Employee> employeeList = school.getEmployeeList();
        for (Employee e : employeeList) {
            if (e instanceof Teacher) {
                teacherList.add((Teacher) e);
            }
        }
        return teacherList;
    }

    /**
     * getting information about the chosen person(employee)
     *
     * @param t
     */

//    public static void getTeacherInfo(Teacher t) {
//        System.out.println("ID: " + t.getId() + " | Position: " + t.getPosition() + " | Name: " + t.getName() + " | Salary: $" + t.getSalary());
//    }
//
//    /**
//     * choosing one teacher from the lots of teachers in the Teacher list
//     *
//     * @param school
//     * @param name
//     * @return
//     */
//    public static Teacher getChosenTeacher(School school, String name) {
//        List<Teacher> teacherList = getTeacherList(school);
//        Teacher teacher = new Teacher();
//        for (Teacher t : teacherList) {
//            if (t.getName().equals(name)) {
//                teacher = t;
//            }
//        }
//        return teacher;
//    }

    /**
     * Creating information about Teachers
     *
     * @param school
     */

    public static void getTeachersList(School school) {
        List<Teacher> teacherList = getTeacherList(school);
        for (Teacher t : teacherList) {
            System.out.println("ID: " + t.getId() + " | Position: " + t.getPosition() + " | Name: " + t.getName() + " | Salary: $" + t.getSalary() + " | Salary earned: $" + t.getSalaryEarned());
            System.out.println("-----------------------------------------------------------");
        }
    }

    public static void addNewTeacher(Scanner scanner, School school) {
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
                position = "teacher";
            } else {
                System.out.println("Введите зарплату сотрудника...");
                salary = scanner.nextInt();
            }
        }
        System.out.println("Ваш сотрудник ");
        System.out.println("ID: " + id + " | name: " + name + " | position: " + position + " | salary $" + salary );

        Teacher teacher = new Teacher(id, name, position, salary);
        school.addTeacher(teacher);
    }

//    /**
//     * балванка для начисления зарплаты
//     */
//
//    System.out.println("Enter the name of a teacher");
//                Teacher.getTeacherList(school);
//    String teacherName = scanner.next();
//    Teacher teacher = Teacher.getChosenTeacher(school, teacherName);
//    int counter = 1;
//                while (counter<=3) {
//        if (counter == 3) {
//            mainMenu(school, scanner);
//        }
//        if (teacher.getName()!=null) {
//            System.out.println("Your teacher: ");
//            Teacher.getTeacherInfo(teacher);
//            System.out.println("Enter $ for salary...");
//            int salary = scanner.nextInt();
//            if(salary>school.getTotalMoneyEarned()){
//                System.out.println("----------------------------------------------");
//                System.out.println("You don't have enough money");
//                System.out.println("----------------------------------------------");
//                payForEmployees(school, scanner);
//            }
//            else if(salary>teacher.getSalary()){
//                System.out.println("You entered the salary more than the employee has");
//                System.out.println("Please choose: 1 - is agree       2 - is disagree, and go back");
//                choice = scanner.nextInt();
//                switch (choice){
//                    case 1:
//                        teacher.receiveSalary(salary);
//                        break;
//                    case 2:
//                        payForEmployees(school, scanner);
//                }
//            }
//            else if(salary<teacher.getSalary()){
//                System.out.println("You entered the salary less than the employee has");
//                System.out.println("Please choose: 1 - is agree       2 - is disagree, and go back");
//                choice = scanner.nextInt();
//                switch (choice){
//                    case 1:
//                        teacher.receiveSalary(salary);
//                        break;
//                    case 2:
//                        payForEmployees(school, scanner);
//                }
//            }
//            else {
//                teacher.receiveSalary(salary);
//            }
//            finance(school, scanner);
//        }
//        else {
//            System.out.println("You entered incorrect date, re-enter please");
//            teacherName = scanner.next();
//            teacher = Teacher.getChosenTeacher(school, teacherName);
//            counter++;
//        }
//    }

}



