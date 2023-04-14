package pro.sky.skyprospringemployee.Controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.skyprospringemployee.Employee;
import pro.sky.skyprospringemployee.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringemployee.Service.NewEmployeeService;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final NewEmployeeService newEmployeeService;

    public DepartmentController(NewEmployeeService newEmployeeService) {
        this.newEmployeeService = newEmployeeService;
    }

    @GetMapping(path = "/max-salary")
    public Object getEmployeeWithMaxSalaryByDept(@RequestParam("departmentId") int department) {
        try {
            Employee employee = newEmployeeService.getEmployeeWithMaxSalaryByDept(department);
            return employee;
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/min-salary")
    public Object getEmployeeWithMinSalaryByDept(@RequestParam("departmentId") int department) {
        try {
            Employee employee = newEmployeeService.getEmployeeWithMinSalaryByDept(department);
            return employee;
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/all")
    public Object showEmployeesInDepartment(@RequestParam("departmentId") int department) {
        List<Employee> employees = newEmployeeService.showEmployeesInDepartment(department);
        return employees;
    }


    @GetMapping(path = "/all/")
    public Object showAllEmployeesByDepartments() {
        List<Employee> employees = (List<Employee>) newEmployeeService.showAllEmployeesByDepartments();
        return employees;
    }
}
