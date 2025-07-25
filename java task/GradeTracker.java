import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // clear buffer

            students.add(new Student(name, grade));
        }

        double total = 0;
        double highest = -1;
        double lowest = 101;
        String topStudent = "", bottomStudent = "";

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.println("\n--- Grade Summary Report ---");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.grade);
        }

        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (" + bottomStudent + ")");
        
        scanner.close();
    }
}
