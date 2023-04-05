package pro.sky.skyprospringemployee.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;
import pro.sky.skyprospringemployee.Employee;
import pro.sky.skyprospringemployee.Exceptions.EmployeeAlreadyAddException;
import pro.sky.skyprospringemployee.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringemployee.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService{
    Map<String, Employee> employees = new HashMap<>(Map.of(
                getEmployeeKey("Данил", "Багирян"), new Employee("Данил", "Багирян"),
                getEmployeeKey("Яна", "Валуйская"), new Employee("Яна", "Валуйская"),
                getEmployeeKey("Любовь", "Дятлова"), new Employee("Любовь", "Дятлова"),
                getEmployeeKey("Василий", "Гудков"), new Employee("Василий", "Гудков"),
                getEmployeeKey("Александр", "Жердев"), new Employee("Александр", "Жердев"),
                getEmployeeKey("Юлия", "Коряковцева"),  new Employee("Юлия", "Коряковцева"),
                getEmployeeKey("Михаил", "Низовский"), new Employee("Михаил", "Низовский"),
                getEmployeeKey("Егор", "Орехов"), new Employee("Егор", "Орехов"),
                getEmployeeKey("Екатерина", "Перещук"), new Employee("Екатерина", "Перещук")
        )
    );

    public String getEmployeeKey(String firstName, String lastName) {
        String fullName = (firstName + lastName).replace(" ", "");
        String key = "";
        for (int i = 0; i < fullName.length(); i++) {
            char symbol = fullName.charAt(i);
            key += String.valueOf((int)symbol);
        }
        return key;
    }

    private final int employeesCapacity = 14;
    public Employee addEmployee(String firstName, String lastName) {
        if (firstName.replace(" ", "").isEmpty() || lastName.replace(" ", "").isEmpty()) {
            throw new EmployeeNotFoundException("Введите корректно имя и фамилию!!!");
        }
        String key = getEmployeeKey(firstName, lastName);
        if(employees.containsKey(key)) {
            throw new EmployeeAlreadyAddException("Сотрудник в списке уже существует!!!");
        }

        Employee employee = new Employee(firstName, lastName);
        employees.put(getEmployeeKey(firstName, lastName),employee);
        if (employees.size() >= employeesCapacity) {
          throw new EmployeeStorageIsFullException("Список сотрудников переполнен!!!");
        }
        return employee;
    }



    public Employee removeEmployee(String firstName, String lastName) {
        String key = getEmployeeKey(firstName, lastName);
        if(employees.containsKey(key)){
            Employee employee = employees.get(key);
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!!!");
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = getEmployeeKey(firstName, lastName);
        if(employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!!!");
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }


}

