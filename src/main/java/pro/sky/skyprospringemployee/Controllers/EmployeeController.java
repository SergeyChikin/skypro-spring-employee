package pro.sky.skyprospringemployee.Controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.skyprospringemployee.Employee;
import pro.sky.skyprospringemployee.Exceptions.EmployeeNotFoundException;
import pro.sky.skyprospringemployee.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping
@ResponseStatus

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "employee/add")
    public Object addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("salary") double salary,
                              @RequestParam("department") int department){

        try {
            Employee employee = employeeService.addEmployee(firstName, lastName, salary, department);
            return employee;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "employee/remove")
    public Object removeEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName){

        try {
            Employee employee = employeeService.removeEmployee(firstName, lastName);
            return employee;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }


    @GetMapping(path = "employee/find")
    public Object findEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName){

        try {
            Employee employee = employeeService.findEmployee(firstName, lastName);
            return employee;
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "employee/getEmployees")
    public Object getEmployees(){
        return employeeService.getEmployees();
    }


}
