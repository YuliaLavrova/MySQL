package org.example;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(1);
        System.out.println(student);
    }
}
