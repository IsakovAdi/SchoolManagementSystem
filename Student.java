package OOP.SchoolManagementSystem2;

import java.util.List;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private final int feesTotal = 30000;
    private int balance;
    Scanner scanner = new Scanner(System.in);

    /**
     * To create a new student by initializing
     * fees for every student is $30000
     * feesPaid initially is 0
     *
     * @param id    - unique id for every student
     * @param name  - of the student
     * @param grade - of the student
     */
    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
    }

    public Student() {
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void payFees(int fees) {
        feesPaid = feesPaid + fees;
        System.out.println(name + " paid $" + fees);
        School.updateTotalMoneyEarned(fees);
        System.out.println("Current debt: $" + getBalance());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public int getBalance() {
        balance = feesPaid-feesTotal;
        return balance;
    }

    /**
     * Creating information about student
     *
     * @param school
     */
    public static void getStudentsList(School school) {
        List<Student> students = school.getStudentList();
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + " | Name: " + s.getName() + " | Grade : " + s.getGrade() + " | Money paid: " + s.getFeesPaid() + " | balance of payment: $" + s.getBalance() + " | Total: $ " + s.getFeesTotal());
            System.out.println("-----------------------------------------------------------");
        }
    }

    /**
     * choosing one student from the lots of students in the Students list
     *
     * @param school
     * @param name
     * @return
     */

    public static Student getChosenStudent(School school, String name) {
        List<Student> students = school.getStudentList();
        Student student = new Student();
        for (Student s : students) {
            if (s.getName().equals(name)) {
                student = s;
            }
        }
        return student;
    }

    /**
     * getting information about the chosen student
     *
     * @param s
     */

    public static void getStudentInfo(Student s) {
        System.out.println("ID: " + s.getId() + " | Name: " + s.getName() + " | Grade : " + s.getGrade() + " | Money paid: " + s.getFeesPaid() + " | balance of payment: $" + s.getBalance() + " | Total: $ " + s.getFeesTotal());
    }

    public static void payFees(School school, Scanner scanner) {
        System.out.println("Enter the name of a student");
//        Student.getStudentsList(school);
        String studentName = scanner.next();
        Student student = Student.getChosenStudent(school, studentName);
        int counter = 0;
        while (counter <= 2) {
            if (student.getName() != null) {
                System.out.println("Your student: ");
                Student.getStudentInfo(student);
                System.out.println("Enter $ for debt...");
                int debt = scanner.nextInt();
                student.payFees(debt);
                GetInfo.finance(school, scanner);
            } else {
                System.out.println("You entered incorrect date, re-enter please");
                studentName = scanner.next();
                student = Student.getChosenStudent(school, studentName);
                counter++;
                if (counter == 2 && !studentName.equals(student.getName())) {
                    System.out.println("You entered incorrect date three times, please check your information");
                    GetInfo.finance(school, scanner);
                }
            }
        }
    }

    public static void addNewStudent(School school, Scanner scanner) {
        int id = 0;
        String name = null;
        int grade = 0;
        int feesPaid = 0;
        final int feesTotal = 30000;

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                id = GenID.genUniqueId();
            } else if (i == 1) {
                System.out.println("Enter name of student...");
                name = scanner.next();
            } else {
                System.out.println("Enter the grade of student");
                grade = scanner.nextInt();
            }
        }
        System.out.println("Your student: ");
        System.out.println("ID: " + id + " | name: " + name + " | grade: " + grade + " | Money paid $" + feesPaid + " | Balance of payment $-"+ feesTotal + " | Total: $ " + feesTotal);
        Student student = new Student(id, name, grade);
        school.addStudent(student);
    }
}
