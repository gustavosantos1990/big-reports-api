package org.gdas.bigreportsapi.service;

import org.gdas.bigreportsapi.model.entity.Employee;
import org.gdas.bigreportsapi.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final int PAGE_SIZE = 10;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Page<Employee> findPage() {
        Pageable pageable = Pageable.ofSize(PAGE_SIZE);
        return employeeRepository.findAll(pageable);
    }

}
