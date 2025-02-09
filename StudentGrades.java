// Project no.1 for codealpha
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Array to store grades
        double[] grades = new double[numStudents];

        // Input grades for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Calculate average, highest, and lowest grades
        double total = 0;
        double highest = grades[0];
        double lowest = grades[0];

        for (double grade : grades) {
            total += grade;
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = total / numStudents;

        // Display the results
        System.out.println("\nGrade Summary:");
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        scanner.close();
    }
}
