package student;

public class Student {
    private String studentId;
    private String name;
    private String department;
    private int level;
    private double currentCGPA;
    private int totalSemestersCompleted;

    public Student(String studentId, String name, String department, int level,
                   double currentCGPA, int totalSemestersCompleted) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.level = level;
        this.currentCGPA = currentCGPA;
        this.totalSemestersCompleted = totalSemestersCompleted;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getLevel() { return level; }
    public double getCurrentCGPA() { return currentCGPA; }
    public int getTotalSemestersCompleted() { return totalSemestersCompleted; }

    // Setters
    public void setCurrentCGPA(double currentCGPA) { this.currentCGPA = currentCGPA; }
    public void setTotalSemestersCompleted(int total) { this.totalSemestersCompleted = total; }

    public void displayInfo() {
        System.out.println("=============================");
        System.out.println("  STUDENT INFORMATION");
        System.out.println("=============================");
        System.out.println("ID         : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Level      : " + level);
        System.out.println("Current CGPA: " + String.format("%.2f", currentCGPA));
        System.out.println("Semesters  : " + totalSemestersCompleted);
    }
}