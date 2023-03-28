package pro.sky.skyprospringemployee.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringemployee.Employee;
import pro.sky.skyprospringemployee.Exceptions.EmployeeAlreadyAddException;
import pro.sky.skyprospringemployee.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringemployee.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService{
    List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Данил", "Багирян"),
                new Employee("Яна", "Валуйская"),
                new Employee("Любовь", "Дятлова"),
                new Employee("Василий", "Гудков"),
                new Employee("Александр", "Жердев"),
                new Employee("Юлия", "Коряковцева"),
                new Employee("Михаил", "Низовский"),
                new Employee("Егор", "Орехов"),
                new Employee("Екатерина", "Перещук")
        )
    );



    private final int employeesCapacity = 12;
    public Employee addEmployee(String firstName, String lastName) {
        if (firstName.replace(" ", "").isEmpty() || lastName.replace(" ", "").isEmpty()) {
            throw new EmployeeNotFoundException("Введите корректно имя и фамилию!!!");
        }
        for (Employee emp : employees) {
            if (firstName.equals(emp.getFirstName()) && lastName.equals(emp.getLastName())) {
                throw new EmployeeAlreadyAddException("Сотрудник в списке уже существует!!!");
            }
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        if (employees.size() >= employeesCapacity) {
          throw new EmployeeStorageIsFullException("Список сотрудников переполнен!!!");
        }
        return employee;
    }



    public Employee removeEmployee(String firstName, String lastName) {
        for (Employee emp : employees) {
            if (firstName.equals(emp.getFirstName()) && lastName.equals(emp.getLastName())) {
                employees.remove(emp);
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!!!");
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee emp : employees) {
            if (firstName.equals(emp.getFirstName()) && lastName.equals(emp.getLastName())) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!!!");
    }

    public List<Employee> getEmployees() {
        return employees;
    }


}

