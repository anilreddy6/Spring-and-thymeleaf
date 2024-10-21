package com.anil.nimma.thymeleafemploy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	
	@Autowired
    private EmployeeService employeeService;
	
	  @GetMapping("/employees")
	    public String getAllEmployees(Model model) {
	        List<Employee> employees = employeeService.getAllEmployees();
	        model.addAttribute("employees", employees);
	        return "employees";  // Returns the Thymeleaf template for listing employees
	    }
	   // View employee details
    @GetMapping("/employees/view/{id}")
    public String viewEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-details"; // Thymeleaf template name
    }

    // Edit employee details
    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee"; // Thymeleaf template name
    }

    // Update employee details (after form submission)
    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee updatedEmployee) {
        employeeService.updateEmployee(id, updatedEmployee);  // Update the employee
        return "redirect:/employees";  // Redirect to the employee list after updating
    }
}

 
    

