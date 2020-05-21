package OOP.SchoolManagementSystem2;

import java.util.List;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private String position;
    private int salaryEarned;

    public int getSalaryEarned() {
        return salaryEarned;
    }

    public void setSalaryEarned(int salaryEarned) {
        this.salaryEarned = salaryEarned;
    }

    public Employee() {
    }

    public Employee(int id, String name, String position, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * присвоение заработной платы сотрудника
     *
     * @param salary
     */
    public void receiveSalary(int salary) {
        School.updateTotalMoneySpent(salary);
        System.out.println(name + " got salary of $" + salary);
    }

    /**
     * Creating information about all Employees
     *
     * @param school
     */
    public static void getEmployeesList(School school) {
        List<Employee> employees = school.getEmployeeList();
        for (Employee e : employees) {
            System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + " | Position: " + e.getPosition()  + " | Salary: $" + e.getSalary()+ " | Salary earned: $" + e.getSalaryEarned());
            System.out.println("-----------------------------------------------------------");
        }
    }

    /**
     * getting information about the chosen person(employee)
     *
     * @param e
     */

    public static void getEmployeeInfo(Employee e) {
        System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + " | Position: " + e.getPosition()  + " | Salary: $" + e.getSalary() + " | Salary earned: $" + e.getSalaryEarned());
    }

//    /**
//     * из общего списка Employee выводим список объектов Teacher
//     *
//     * @param school
//     * @return
//     */
//
//    public static List<Employee> getEmployeeList(School school) {
//        List<Employee> employeeList = new ArrayList<>();
//        List<Employee> EmployeeList1 = school.getEmployeeList();
//        for (Employee e : employeeList) {
//            if (e instanceof Employee)
//            employeeList.add((Employee) e);
//        }
//        return employeeList;
//    }

    /**
     * choosing one teacher from the lots of teachers in the Teacher list
     *
     * @param school
     * @param name
     * @return
     */
    public static Employee getChosenEmployee(School school, String name) {
        List<Employee> employeeList = school.getEmployeeList();
        Employee employee = new Employee();
        for (Employee e : employeeList) {
            if (e.getName().equals(name)) {
                employee = e;
            }
        }
        return employee;
    }

    /**
     * поиск сотрудника введенной с консоли начисление заработной платы
     *
     * @param school
     * @param scanner
     */

    public static void makePayment(School school, Scanner scanner) {
        System.out.println("Enter the name of an Employee");
//        getEmployeesList(school);
        String employeeName = scanner.next();
        Employee employee = getChosenEmployee(school, employeeName);
        int counter = 0;
        while (counter <= 2) {

            if (employee.getName() != null) {
                System.out.println("Your employee: ");
                getEmployeeInfo(employee);
                System.out.println("Enter $ for salary...");
                int salary = scanner.nextInt();
                if (salary > school.getTotalMoneyEarned()) {
                    System.out.println("----------------------------------------------");
                    System.out.println("You don't have enough money");
                    System.out.println("----------------------------------------------");
                    GetInfo.payForEmployees(school, scanner);
                } else if (salary > employee.getSalary()) {
                    System.out.println("You entered the salary more than the employee has");
                    System.out.println("Please choose: 1 - is agree       2 - is disagree, and go back");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            employee.receiveSalary(salary);
                            employee.setSalaryEarned(salary);
                            break;
                        case 2:
                            GetInfo.payForEmployees(school, scanner);
                    }
                } else if (salary < employee.getSalary()) {
                    System.out.println("You entered the salary less than the employee has");
                    System.out.println("Please choose: 1 - is agree       2 - is disagree, and go back");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            employee.receiveSalary(salary);
                            employee.setSalaryEarned(salary);
                            break;
                        case 2:
                            GetInfo.payForEmployees(school, scanner);
                    }
                } else {
                    employee.receiveSalary(salary);
                    employee.setSalaryEarned(salary);
                }
                GetInfo.finance(school, scanner);
            } else {
                System.out.println("You entered incorrect date, re-enter please");
                employeeName = scanner.next();
                employee = getChosenEmployee(school, employeeName);
                counter++;
                if (counter == 2 && !employeeName.equals(employee.getName())) {
                    System.out.println("You entered incorrect date three times, please check your information");
                    GetInfo.finance(school, scanner);
                }
            }
        }
    }

    public static void getEmployeeInformation(School school, Scanner scanner){
        System.out.println("Please, enter the name of employee");
        String employeeName = scanner.next();
        Employee employee = getChosenEmployee(school, employeeName);
        int counter = 0;
        while (counter <= 2) {
            if (employee.getName()!=null){
                System.out.println("Yor employee");
                getEmployeeInfo(employee);
                GetInfo.EmployeeList(school, scanner);
            }
            else {
                System.out.println("You entered incorrect date, re-enter please");
                employeeName = scanner.next();
                employee = getChosenEmployee(school, employeeName);
                counter++;
                if (counter ==2 && !employeeName.equals(employee.getName())){
                    System.out.println("You entered incorrect date three times, please check your information");
                    GetInfo.EmployeeList(school, scanner);
                }
            }
        }
    }


    /**
     * получаем зарплату всех сотрудников
     * @param school
     * @return
     */

    public static int AllEmployeesSalary(School school) {
        List<Employee> employeeList = school.getEmployeeList();
        int allSalary = 0;
        for (Employee e : employeeList) {
            int tempSalary = e.getSalary();
            allSalary = allSalary + tempSalary;
        }
        return allSalary;
    }

    /**
     * начисленик заработной платы всем сотрудникам
     * @param school
     * @param scanner
     */

    public static void payForAllEmployees(School school, Scanner scanner) {
        List<Employee> employeeList = school.getEmployeeList();
        int employeesSalary = AllEmployeesSalary(school);
        if (school.getTotalMoneyEarned() > employeesSalary) {
            System.out.println("Salary of all your employees is: $" + AllEmployeesSalary(school));
            System.out.println("Please, choose an option: ");
            System.out.println("1. Pay for all          2. Go to the finance section ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int generalTotalEarned = school.getTotalMoneyEarned() - employeesSalary;
                    School.setTotalMoneyEarned(generalTotalEarned);
                    int generalTotalMoneySpent = school.getTotalMoneySpent() + employeesSalary;
                    School.setTotalMoneySpent(generalTotalMoneySpent);
                    System.out.println("All your employees got salary");
                    for (Employee e : employeeList) {
                        int tempSalary = e.getSalary();
                        e.setSalaryEarned(tempSalary);
                    }
                    GetInfo.finance(school, scanner);
                case 2:
                    GetInfo.finance(school, scanner);
            }
        }
        else {
            System.out.println("You don't have enough money");
            GetInfo.finance(school, scanner);
        }
    }
}
