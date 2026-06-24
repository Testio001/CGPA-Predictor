package main;

import course.Course;
import java.util.Scanner;
import service.GPACalculator;
import student.Student;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  STUDENT CGPA PREDICTION SYSTEM");
        System.out.println("  Elizade University");
        System.out.println("=============================================\n");

        // --- Student Registration ---
        System.out.print("Enter Student ID     : ");
        String id = scanner.nextLine();

        System.out.print("Enter Name           : ");
        String name = scanner.nextLine();

        System.out.print("Enter Department     : ");
        String dept = scanner.nextLine();

        System.out.print("Enter Level          : ");
        int level = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Current CGPA   : ");
        double cgpa = Double.parseDouble(scanner.nextLine());

        System.out.print("Semesters Completed  : ");
        int semesters = Integer.parseInt(scanner.nextLine());

        Student student = new Student(id, name, dept, level, cgpa, semesters);

        // --- Course Registration ---
        System.out.print("\nHow many courses this semester? ");
        int numCourses = Integer.parseInt(scanner.nextLine());

        GPACalculator calculator = new GPACalculator();

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("\n--- Course " + i + " ---");
            System.out.print("Course Code : ");
            String code = scanner.nextLine();

            System.out.print("Units       : ");
            int units = Integer.parseInt(scanner.nextLine());

            System.out.print("Grade (A/B/C/D/E/F): ");
            String grade = scanner.nextLine();

            calculator.addCourse(new Course(code, units, grade));
        }

        // --- Calculations ---
        double semesterGPA = calculator.calculate();
        double predictedCGPA = calculator.predictCGPA(cgpa, semesters, semesterGPA);
        String standing = calculator.getAcademicStanding(predictedCGPA);

        // --- Result Summary ---
        System.out.println("\n\n=============================================");
        System.out.println("           RESULT SUMMARY");
        System.out.println("=============================================");
        student.displayInfo();

        System.out.println("\n--- Courses Registered ---");
        for (Course c : calculator.getCourses()) {
            c.displayCourse();
        }

        System.out.println("\n--- Performance Analysis ---");
        System.out.println("Semester GPA     : " + String.format("%.2f", semesterGPA));
        System.out.println("Predicted CGPA   : " + String.format("%.2f", predictedCGPA));
        System.out.println("Academic Standing: " + standing);

        System.out.println("\n--- Bonus Stats ---");
        System.out.println("Total Units      : " + calculator.getTotalUnits());
        System.out.println("Passed           : " + calculator.getPassedCount() + " course(s)");
        System.out.println("Failed           : " + calculator.getFailedCount() + " course(s)");

        Course best = calculator.getBestCourse();
        Course weakest = calculator.getWeakestCourse();

        if (best != null)
            System.out.println("Best Course      : " + best.getCourseCode() + " (" + best.getGrade() + ")");
        if (weakest != null)
            System.out.println("Weakest Course   : " + weakest.getCourseCode() + " (" + weakest.getGrade() + ")");

        System.out.println("\n=============================================");
        System.out.println("  Analysis Complete. Good luck, " + student.getName() + "!");
        System.out.println("=============================================");
    }
}