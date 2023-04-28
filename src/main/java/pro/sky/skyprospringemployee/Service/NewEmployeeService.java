package pro.sky.skyprospringemployee.Service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringemployee.Employee;
import pro.sky.skyprospringemployee.Exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class NewEmployeeService extends EmployeeService{


    public Employee getEmployeeWithMaxSalaryByDept(int department) {

        return   Collections.unmodifiableCollection(employees.values()).stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee -> Employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Отдел не найден!"));

    }


    public Employee getEmployeeWithMinSalaryByDept(int department) {

        return  Collections.unmodifiableCollection(employees.values()).stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee -> Employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Отдел не найден!"));
    }


    public List<Employee> showEmployeesInDepartment(int department) {

        return  Collections.unmodifiableCollection(employees.values()).stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }


    public List<Employee> showAllEmployeesByDepartments() {

        return   Collections.unmodifiableCollection(employees.values()).stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList());
    }



}

