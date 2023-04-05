package pro.sky.skyprospringemployee;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
