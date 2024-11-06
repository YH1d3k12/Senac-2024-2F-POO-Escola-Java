package dao;

import models.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    
    // Função para obter todos os estudantes com STATEMENT.
    public static List<Student> getStudents(Connection con) {
        List<Student> students = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet sql = stmt.executeQuery(query);
            
            while (sql.next()) {
                Student student = new Student(
                    sql.getString("name"),
                    sql.getDate("birthday"),
                    sql.getString("cpf"),
                    sql.getInt("id_course")
                );
                student.setId(sql.getInt("id"));
                student.setCourse(CourseDAO.getCourseById(con, sql.getInt("id_course")));
                students.add(student); 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    // Função para obter um estudante com PREP STATEMENT.
    public static Student getStudentById(Connection con, Integer id) {
        Student student = null;
        
        try {
            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();
            
            if (sql.next()) {
                student = new Student(
                    sql.getString("name"),
                    sql.getDate("birthday"),
                    sql.getString("cpf"),
                    sql.getInt("id_course")
                );
                student.setId(sql.getInt("id"));
                student.setCourse(CourseDAO.getCourseById(con, sql.getInt("id_course")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
}