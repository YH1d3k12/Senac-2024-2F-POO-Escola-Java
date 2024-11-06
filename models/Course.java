package models;

import java.util.Scanner;

public class Course {
    private Integer id;
    private String name;
    private Integer workload;
    private Integer id_teacher;
    private Teacher teacher;

    public Course(
        String name,
        Integer workload,
        Integer id_teacher
    ) {
        this.name = name;
        this.workload = workload;
        this.id_teacher = id_teacher;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public void setTeacherId(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // Getters
    Integer getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    Integer getWorkload() {
        return this.workload;
    }
    
    Integer getInteger() {
        return this.id_teacher;
    }

    Integer getTeacher() {
        return this.id_teacher;
    }

    @Override
    public String toString() {
        return (
            "ID: " + this.id +
            "\nNome: " + this.name + 
            "\nCarga Horária: " + this.workload + 
            "\nProfessor(a): " + this.teacher.getName() +
            "\n -----------------------------------------"
        );
    }

    public static Course createCourse(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome do curso: ", scanner);
        Integer workload = utilities.GetValues.getIntInput("Digite a carga horária do curso: ", scanner);
        Integer id_teacher = utilities.GetValues.getIntInput("Digite o ID do professor(a) responsável pelo curso: ", scanner);
        return new Course(name, workload, id_teacher);
    }
}
