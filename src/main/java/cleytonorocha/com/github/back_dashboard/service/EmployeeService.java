package cleytonorocha.com.github.back_dashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cleytonorocha.com.github.back_dashboard.model.entity.Employee;
import cleytonorocha.com.github.back_dashboard.model.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(m -> {
                    m.setId(employee.getId());
                    return employeeRepository.save(m);
                }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
