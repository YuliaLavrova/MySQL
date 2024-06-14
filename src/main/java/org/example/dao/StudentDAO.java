package org.example.dao;

import org.example.model.Group;
import org.example.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                student.setStudentGroupId(resultSet.getInt("students_group_id"));
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
                student.setStudentGroupId(resultSet.getInt("students_group_id"));
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
        String query = "INSERT INTO mydb.students(`first_name`, `last_name`, `age`, `students_group_id`) VALUES (?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setInt(4, student.getStudentGroupId());
            preparedStatement.execute();
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public void deleteStudentById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            preparedStatement = connection.prepareStatement("DELETE FROM `mydb`.`students` WHERE id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public Map<Student, String> studentsWithGroupNumber() throws SQLException {
        Map<Student, String> map = new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
            preparedStatement = connection.prepareStatement("SELECT * FROM `mydb`.`students` INNER JOIN `mydb`.`students_group` ON `students`.`students_group_id`=`students_group`.`id`;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                group.setNumber(resultSet.getString("students_group.number"));
                group.setId(resultSet.getInt("students_group.id"));
                Student student = new Student();
                student.setStudentName(resultSet.getString("first_name"));
                student.setStudentLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                student.setStudentGroupId(resultSet.getInt("students_group_id"));
                map.put(student, group.getNumber());
            }
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return map;
    }

}
