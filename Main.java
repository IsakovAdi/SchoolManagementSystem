package OOP.SchoolManagementSystem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Teacher zimre = new Teacher(GenID.genUniqueId(),"Zimre","teacher", 250);
        Teacher mellisa = new Teacher(GenID.genUniqueId(),"Mellisa", "teacher",500);
        Teacher lisa = new Teacher(GenID.genUniqueId(),"Lisa", "teacher",600);

        Chief zumrad = new Chief(GenID.genUniqueId(),"Zumrad","chief",150);

        Janitor abai = new Janitor(GenID.genUniqueId(), "Abai", "janitor",100);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(zimre);
        employeeList.add(mellisa);
        employeeList.add(lisa);
        employeeList.add(zumrad);
        employeeList.add(abai);

        Student bolot = new Student(GenID.genUniqueId(),"Bolot", 6 );
        Student akyl = new Student(GenID.genUniqueId(),"Akyl", 2 );
        Student sanjar = new Student(GenID.genUniqueId(),"Sanjar", 11 );

        List<Student> studentList = new ArrayList<>();
        studentList.add(bolot);
        studentList.add(akyl);
        studentList.add(sanjar);

        School agaKhan = new School("AgaKhan", employeeList, studentList);
        Scanner scanner = new Scanner(System.in);
        GetInfo.mainMenu(agaKhan, scanner);
    }
}
