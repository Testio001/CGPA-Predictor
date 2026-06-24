package service;

import course.Course;
import java.util.ArrayList;

public class GPACalculator implements Calculator {
    private ArrayList<Course> courses;

    public GPACalculator() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public double calculate() {
        int totalQualityPoints = 0;
        int totalUnits = 0;

        for (Course c : courses) {
            totalQualityPoints += c.getGradePoint() * c.getUnit();
            totalUnits += c.getUnit();
        }

        if (totalUnits == 0) return 0.0;
        return (double) totalQualityPoints / totalUnits;
    }

    public double predictCGPA(double currentCGPA, int semestersCompleted, double newSemesterGPA) {
        // Weighted average: (old CGPA * semesters + new GPA) / (semesters + 1)
        return ((currentCGPA * semestersCompleted) + newSemesterGPA) / (semestersCompleted + 1);
    }

    public String getAcademicStanding(double cgpa) {
        if (cgpa >= 4.50) return "First Class";
        else if (cgpa >= 3.50) return "Second Class Upper";
        else if (cgpa >= 2.40) return "Second Class Lower";
        else if (cgpa >= 1.50) return "Third Class";
        else if (cgpa >= 1.00) return "Pass";
        else return "Fail";
    }

    public Course getBestCourse() {
        if (courses.isEmpty()) return null;
        Course best = courses.get(0);
        for (Course c : courses) {
            if (c.getGradePoint() > best.getGradePoint()) best = c;
        }
        return best;
    }

    public Course getWeakestCourse() {
        if (courses.isEmpty()) return null;
        Course weakest = courses.get(0);
        for (Course c : courses) {
            if (c.getGradePoint() < weakest.getGradePoint()) weakest = c;
        }
        return weakest;
    }

    public int getTotalUnits() {
        int total = 0;
        for (Course c : courses) total += c.getUnit();
        return total;
    }

    public int getPassedCount() {
        int count = 0;
        for (Course c : courses) if (c.isPassed()) count++;
        return count;
    }

    public int getFailedCount() {
        return courses.size() - getPassedCount();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
