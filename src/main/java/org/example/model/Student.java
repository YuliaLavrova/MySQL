package org.example.model;

public class Student {

    private String studentName;

    private String StudentLastName;

    private int age;

    private int studentGroup;

    public Student(String studentName, String studentLastName, int age, int studentGroup) {
        this.studentName = studentName;
        StudentLastName = studentLastName;
        this.age = age;
        this.studentGroup = studentGroup;
    }

    public Student() {
    }

    public int getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(int studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return StudentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        StudentLastName = studentLastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", StudentLastName='" + StudentLastName + '\'' +
                ", age=" + age +
                ", studentGroup=" + studentGroup +
                '}';
    }
}
