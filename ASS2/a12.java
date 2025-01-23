package com.ASS2;
import java.util.*;
class Course {
    private String courseCode;
    private String courseName;
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    //Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}
// Class: Student
class Student {
    private int studentId;
    private String name;
    private Map<Course, Double> grades;
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.grades = new HashMap<>();
    }
    public int getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public void assignGrade(Course course, double grade) {
        grades.put(course, grade);
        System.out.println("Grade " + grade + " assigned for course " + course.getCourseName() + " to " + name);
    }
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double totalGrades = 0;
        for (double grade : grades.values()) {
            totalGrades += grade;
        }
        return totalGrades / grades.size();
    }
    public void displayGrades() {
        System.out.println("Grades for " + name + ":");
        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    //Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", GPA: " + calculateGPA();
    }
}
// Main Class
public class a12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create sample courses
        Course hindiCourse = new Course("CS101", "Hindi");
        Course teluguCourse = new Course("CS102", "Telugu");
        Course englishCourse = new Course("CS103", "English");
        // Create a student
        Student student = new Student(1, "Anish");
        // Assign grades
        student.assignGrade(hindiCourse, 95.5);
        student.assignGrade(teluguCourse, 80.0);
        student.assignGrade(englishCourse, 100.0);
        // Display grades and GPA
        student.displayGrades();
        System.out.println("GPA: " + student.calculateGPA());
        scanner.close();
    }
}
