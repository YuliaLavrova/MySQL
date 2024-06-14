package org.example.model;

public class Student {

    private String studentName;

    private String StudentLastName;

    private int age;

    private int studentGroupId;

    public Student(String studentName, String studentLastName, int age, int studentGroup) {
        this.studentName = studentName;
        StudentLastName = studentLastName;
        this.age = age;
        this.studentGroupId = studentGroup;
    }

    public Student() {
    }

    public int getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(int studentGroupId) {
        this.studentGroupId = studentGroupId;
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
                ", age=" + age + '\'' +
                ", studentGroup=" + studentGroupId +
                '}';
    }
}
