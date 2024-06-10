package org.example;

import org.example.dao.StudentDAO;
import org.example.model.Student;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class AppTest{

    @Test
    public void getStudentTest() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(2);
        System.out.println(student);
    }

    @Test
    public void getStudentsTest() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> list = studentDAO.getStudents();
        System.out.println(list);
    }

    @Test
    public void insertNewStudentTest() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> list = studentDAO.getStudents();
        System.out.println(list);
        Student student = new Student("Alex", "Pen", 22, 1);
        System.out.println(student);
        studentDAO.insert(student);
        List<Student> list2 = studentDAO.getStudents();
        System.out.println(list2);
    }

}
