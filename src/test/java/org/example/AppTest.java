package org.example;

import org.example.dao.StudentDAO;
import org.example.model.Student;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AppTest {

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
        Student student = new Student("Leo", "Dilan", 22, 1);
        System.out.println(student);
        studentDAO.insert(student);
        List<Student> list2 = studentDAO.getStudents();
        System.out.println(list2);
    }

    @Test
    public void deleteStudentsTest() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> list1 = studentDAO.getStudents();
        System.out.println(list1);
        studentDAO.deleteStudentById(3);
        List<Student> list2 = studentDAO.getStudents();
        System.out.println(list2);
    }

    @Test
    public void joinStudents() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> list1 = studentDAO.getStudents();
        System.out.println(list1);
        Map<Student, String> map = studentDAO.studentsWithGroupNumber();
        map.entrySet().stream().forEach(System.out::println);
    }
}