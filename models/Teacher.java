package models;

// import java.util.Scanner;
import java.sql.Date;
import java.util.Scanner;

public class Teacher extends Person {
    private Integer id;
    private String department;

    public Teacher(
        String name,
        Date birthday,
        String cpf,
        String department
    ) {
        super(name, birthday, cpf);
        this.department = department;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return (
            "\nID: " + this.id +
            "\nNome: " + this.getName() + 
            "\nData de Nascimento: " + this.getBirthDay() + 
            "\nCPF: " + this.getCPF() +
            "\nDepartamento: " + this.getDepartment() +
            "\n -----------------------------------------"
        );
    }

    public static Teacher createTeacher(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome do professor(a): ", scanner);
        Date birthday = utilities.GetValues.getDateInput("Digite a data de nascimento do professor(a): ", scanner);
        String cpf = utilities.GetValues.getStringInput("Digite o CPF do professor(a): ", scanner);
        String department = utilities.GetValues.getStringInput("Digite o departamento do professor(a): ", scanner);
        return new Teacher(name, birthday, cpf, department);
    }
}
