package day4_quiz1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class students {
    protected String name;
    protected int age;

    public students(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Student extends students {
    private List<Course> completedCourses = new ArrayList<>();
    public Student(String name, int age) {
        super(name, age);
    }
    public void complete(Course course) {
        completedCourses.add(course);
    }
    public List<Course> CompletedCourses() {
        return completedCourses;
    }
}
class Professor extends students {
    public Professor(String name, int age) {
        super(name, age);
    }
}
class Course {
    private String name;
    private List<Course> prerequisites = new ArrayList<>();
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }
    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }
    public void enrollStudent(Student student) {
        if (student.CompletedCourses().containsAll(prerequisites)) {
            enrolledStudents.add(student);
            System.out.println("Enrolled student " + student.name + " in course " + name);
        } else {
            System.out.println("Student " + student.name + " does not meet prerequisites for course " + name);
        }
    }
    public void displayEnrolledStudents() {
        System.out.println("Enrolled students in course " + name + ":");
        enrolledStudents.forEach(student ->
                System.out.println("Name: " + student.name + ", Age: " + student.age));
    }
}
public class question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student age: ");
        int studentAge = scanner.nextInt();
        Student student = new Student(studentName, studentAge);
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = new Course(courseName);
        int numPrerequisites;
        while (true) {
            try {
                System.out.print("Enter number of prerequisites: ");
                numPrerequisites = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        for (int i = 0; i < numPrerequisites; i++) {
            System.out.print("Enter prerequisite course name: ");
            String prerequisiteName = scanner.nextLine();
            Course prerequisite = new Course(prerequisiteName);
            course.addPrerequisite(prerequisite);
        }
        student.complete(course);
        course.enrollStudent(student);
        course.displayEnrolledStudents();
        scanner.close();
    }
}


