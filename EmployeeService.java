package com.anil.nimma.thymeleafemploy;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

	List<Employee> employeeList = new ArrayList<>();
	
	 public EmployeeService() {
	        // Adding some employees to the list
	        employeeList.add(new Employee(1L, "Anil reddy", "anil.reddy@example.com", "Software Engineer"));
	        employeeList.add(new Employee(2L, "Lina reddy", "lina.reddy@example.com", "Project Manager"));
	        employeeList.add(new Employee(3L, "Nikhil", "nikhil.n@example.com", "QA Engineer"));
	        employeeList.add(new Employee(4L, "ram venkat", "ram.venkat@example.com", "DevOps Engineer"));
	    }
  

public List<Employee> getAllEmployees() {
       
        return employeeList;
    }


public Employee getEmployeeById(int id) {
	
	
    for (Employee employee : employeeList) {
        if (employee.getId() == id) {
            return employee;  // Return employee if found
        }
    }
    // If employee is not found, return null or throw an exception based on your preference
    return null;
}
    public void updateEmployee(int id, Employee updatedEmployee) {
        // Loop through the list to find the employee by ID
        for (Employee existingEmployee : employeeList) {
            if (existingEmployee.getId() == id) {
                existingEmployee.setName(updatedEmployee.getName());
                existingEmployee.setEmail(updatedEmployee.getEmail());
                existingEmployee.setDesignation(updatedEmployee.getDesignation());
                return; // Exit after updating the employee
            }
        }
    
}





}
