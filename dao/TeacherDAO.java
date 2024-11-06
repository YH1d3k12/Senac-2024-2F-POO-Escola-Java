package dao;

import models.Teacher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherDAO {
    
    // Função para obter todos os professores com STATEMENT.
    public static List<Teacher> getTeachers(Connection con) {
        List<Teacher> teachers = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM teacher";
            Statement stmt = con.createStatement();
            ResultSet sql = stmt.executeQuery(query);
            
            while (sql.next()) {
                Teacher teacher = new Teacher(
                    sql.getString("name"),
                    sql.getDate("birthday"),
                    sql.getString("cpf"),
                    sql.getString("department")
                );
                teacher.setId(sql.getInt("id"));
                teachers.add(teacher); 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teachers;
    }

    // Função para obter um professor com PREP STATEMENT.
    public static Teacher getTeacherById(Connection con, Integer id) {
        Teacher teacher = null;
        
        try {
            String query = "SELECT * FROM teacher WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();
            
            if (sql.next()) {
                teacher = new Teacher(
                    sql.getString("name"),
                    sql.getDate("birthday"),
                    sql.getString("cpf"),
                    sql.getString("department")
                );
                teacher.setId(sql.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }

    // Função para inserir um professor com PREP STATEMENT.
    public static Teacher createTeacher(Connection con) {
        Scanner scanner = new Scanner(System.in);
        try {
            Teacher newTeacher = Teacher.createTeacher(scanner);

            String query = "INSERT INTO teacher (name, birthday, cpf, department) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, newTeacher.getName());
            stmt.setDate(2, newTeacher.getBirthDay());
            stmt.setString(3, newTeacher.getCPF());
            stmt.setString(4, newTeacher.getDepartment());
            stmt.execute();

            return newTeacher;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o professor: " + e.getMessage());
            return null;
        }
    }
}