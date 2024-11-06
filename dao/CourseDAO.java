package dao;

import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    
    // Função para obter todos os cursos com STATEMENT.
    public static List<Course> getCourses(Connection con) {
        List<Course> courses = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM course";
            Statement stmt = con.createStatement();
            ResultSet sql = stmt.executeQuery(query);
            
            while (sql.next()) {
                Course course = new Course(
                    sql.getString("name"),
                    sql.getInt("workload"),
                    sql.getInt("id_teacher")
                );
                course.setId(sql.getInt("id"));
                course.setTeacher(TeacherDAO.getTeacherById(con, sql.getInt("id_teacher")));
                courses.add(course); 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }

    // Função para obter um curso com PREP STATEMENT.
    public static Course getCourseById(Connection con, Integer id) {
        Course course = null;
        
        try {
            String query = "SELECT * FROM course WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();
            
            if (sql.next()) {
                course = new Course(
                    sql.getString("name"),
                    sql.getInt("workload"),
                    sql.getInt("id_teacher")
                );
                course.setId(sql.getInt("id"));
                course.setTeacher(TeacherDAO.getTeacherById(con, sql.getInt("id_teacher")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return course;
    }
}