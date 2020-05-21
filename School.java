package OOP.SchoolManagementSystem2;


import java.util.List;

public class School {


    private List<Employee> employeeList;
    private List<Student> studentList;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;
    private String schoolName;


    /**
     * new object of class school
     * @param employeeList - list of employees
     * @param studentList - list of students
     */
    public School(String schoolName, List<Employee> employeeList, List<Student> studentList) {
        this.employeeList = employeeList;
        this.studentList = studentList;
        this.schoolName = schoolName;
    }

    public void getMessageOfTotalMoneyEarned(){
        System.out.println(getSchoolName()+" has earned $" +getTotalMoneyEarned());
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
        totalMoneyEarned = totalMoneyEarned - totalMoneySpent;
    }
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public static void setTotalMoneyEarned(int totalMoneyEarned) {
        School.totalMoneyEarned = totalMoneyEarned;
    }

    public static void setTotalMoneySpent(int totalMoneySpent) {
        School.totalMoneySpent = totalMoneySpent;
    }
    public void addTeacher(Teacher teacher){
        employeeList.add(teacher);
    }
    public void addJanitor(Janitor janitor){
        employeeList.add(janitor);
    }
    public void addChief(Chief chief){
        employeeList.add(chief);
    }
    public void addStudent(Student student){
        studentList.add(student);
    }

}
