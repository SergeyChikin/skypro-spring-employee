package pro.sky.skyprospringemployee.Service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringemployee.Employee;
import pro.sky.skyprospringemployee.Exceptions.EmployeeAlreadyAddException;
import pro.sky.skyprospringemployee.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringemployee.Exceptions.EmployeeStorageIsFullException;
import java.util.stream.Collectors;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import pro.sky.skyprospringemployee.Exceptions.InvalidInputException;

import static java.util.Arrays.stream;

@Service
public class EmployeeService{
    Map<String, Employee> employees = new HashMap<>(Map.of(
                getEmployeeKey("Данил", "Багирян"),
            new Employee("Данил", "Багирян",55000,2),
                getEmployeeKey("Яна", "Валуйская"),
            new Employee("Яна", "Валуйская",48000,4),
                getEmployeeKey("Любовь", "Дятлова"),
            new Employee("Любовь", "Дятлова",64000,3),
                getEmployeeKey("Василий", "Гудков"),
            new Employee("Василий", "Гудков",57000,2),
                getEmployeeKey("Александр", "Жердев"),
            new Employee("Александр", "Жердев",52000,4),
                getEmployeeKey("Юлия", "Коряковцева"),
            new Employee("Юлия", "Коряковцева",70000,1),
                getEmployeeKey("Михаил", "Низовский"),
            new Employee("Михаил", "Низовский",47000,5),
                getEmployeeKey("Егор", "Орехов"),
            new Employee("Егор", "Орехов",62000,3),
                getEmployeeKey("Екатерина", "Перещук"),
            new Employee("Екатерина", "Перещук",72000,1)
        )
    );

    private final int employeesCapacity = 12;

    private String getEmployeeKey(String firstName, String lastName) {
        String fullName = StringUtils.replace(firstName + lastName, " ", "");
        String key = "";
        for (int i = 0; i < fullName.length(); i++) {
            char symbol = fullName.charAt(i);
            key += String.valueOf((int)symbol);
        }
        return key;
    }


    public Employee addEmployee(String firstName, String lastName, double salary, int department) {

        if (!validateInput(firstName, lastName)) {
            throw new InvalidInputException();
        }

        String key = getEmployeeKey(firstName, lastName);
        if(employees.containsKey(key)) {
            throw new EmployeeAlreadyAddException("Сотрудник в списке уже существует!!!");
        }

        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.put(getEmployeeKey(firstName, lastName),employee);
        if (employees.size() >= employeesCapacity) {
          throw new EmployeeStorageIsFullException("Список сотрудников переполнен!!!");
        }
        return employee;
    }


    public Employee removeEmployee(String firstName, String lastName) {
        if (!validateInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        String key = getEmployeeKey(firstName, lastName);
        if(employees.containsKey(key)){
            Employee employee = employees.get(key);
            employees.remove(key);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!!!");
    }


    public Employee findEmployee(String firstName, String lastName) {
        if (!validateInput(firstName, lastName)) {
            throw new InvalidInputException();
        }

        String key = getEmployeeKey(firstName, lastName);
        if(employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!!!");
    }


    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private boolean validateInput(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }

}

