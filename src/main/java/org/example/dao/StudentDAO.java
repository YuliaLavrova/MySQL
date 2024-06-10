package org.example.dao;

import org.example.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public Student getStudentById(int id) throws SQLException {
        Student student = new Student();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            preparedStatement = connection.prepareStatement("SELECT * FROM mydb.students WHERE id = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setStudentName(resultSet.getString("first_name"));
                student.setStudentLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
            }
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return student;
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            preparedStatement = connection.prepareStatement("SELECT * FROM mydb.students;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentName(resultSet.getString("first_name"));
                student.setStudentLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return list;
    }

    public void insert(Student student) throws SQLException {
        String query = "INSERT INTO 'mydb'.'students'('first_name', 'last_name', 'age', 'students'_group_id') VALUES (?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setInt(4, student.getStudentGroup());
            preparedStatement.execute();
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }
}
