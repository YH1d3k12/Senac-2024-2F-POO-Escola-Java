package models;

import java.util.Scanner;
import java.sql.Date;

public class Student extends Person {
    private Integer id;
    private Integer idCourse;
    private Course course;

    public Student(
        String name,
        Date birthday,
        String cpf,
        Integer idCourse
    ) {
        super(name, birthday, cpf);
        this.idCourse = idCourse;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourseId(Integer id) {
        this.idCourse = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

    public Integer getCourse() {
        return this.idCourse;
    }

    public Course getStudentCourse() {
        return this.course;
    }

    @Override
    public String toString() {
        return (
            "ID: " + this.id +
            "\nNome: " + this.getName() + 
            "\nData de Nascimento: " + this.getBirthDay() + 
            "\nCPF: " + this.getCPF() +
            "\nCurso: " + this.course.getName() +
            "\nCarga Horária: " + this.course.getWorkload() +
            "\n -----------------------------------------"
        );
    }

    public static Student createStudent(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome do aluno(a): ", scanner);
        Date birthday = utilities.GetValues.getDateInput("Digite a data de nascimento do aluno(a) (yyyy-MM-dd): ", scanner);
        String cpf = utilities.GetValues.getStringInput("Digite o CPF do aluno(a): ", scanner);
        Integer course = utilities.GetValues.getIntInput("Digite o ID do curso do aluno(a): ", scanner);
        Student newStudent = new Student(name, birthday, cpf, course);
        return newStudent;
    }
}
