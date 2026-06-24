package course;

public class Course {
    private String courseCode;
    private int unit;
    private String grade;

    public Course(String courseCode, int unit, String grade) {
        this.courseCode = courseCode;
        this.unit = unit;
        this.grade = grade.toUpperCase();
    }

    public String getCourseCode() { return courseCode; }
    public int getUnit() { return unit; }
    public String getGrade() { return grade; }

    public int getGradePoint() {
        switch (grade) {
            case "A": return 5;
            case "B": return 4;
            case "C": return 3;
            case "D": return 2;
            case "E": return 1;
            case "F": return 0;
            default:
                System.out.println("Invalid grade for " + courseCode + ". Treated as F.");
                return 0;
        }
    }

    public boolean isPassed() {
        return !grade.equals("F");
    }

    public void displayCourse() {
        System.out.println(courseCode + "  |  " + unit + " units  |  Grade: " + grade
                + "  |  Points: " + getGradePoint());
    }
}