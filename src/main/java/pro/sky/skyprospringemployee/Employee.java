package pro.sky.skyprospringemployee;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private int department;


    public Employee(String firstName, String lastName, double salary, int department){
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) &&
                                Double.compare(employee.salary, salary) == 0 &&
                                department == employee.department ;

    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName, salary, department);
    }


    @Override
    public String toString() {
        return "Имя - " + firstName + "; Фамилия - " + lastName + ";";
    }
}
