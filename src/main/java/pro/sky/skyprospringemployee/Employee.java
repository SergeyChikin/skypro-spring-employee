package pro.sky.skyprospringemployee;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private int department;


    public Employee(String firstName, String lastName, double salary, int department){
        this.firstName = firstName;
        this.lastName = lastName;
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
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);

    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName);
    }


    @Override
    public String toString() {
        return "Имя - " + firstName + "; Фамилия - " + lastName + ";";
    }
}
