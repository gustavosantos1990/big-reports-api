package org.gdas.bigreportsapi.service;

import org.gdas.bigreportsapi.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    private static final int REPORT_LIMIT = 50;

    private final EmployeeService employeeService;
    private final KafkaService kafkaService;

    public ReportsService(EmployeeService employeeService, KafkaService kafkaService) {
        this.employeeService = employeeService;
        this.kafkaService = kafkaService;
    }

    public void run() {
        Page<Employee> page = employeeService.findPage();
        if (page.getTotalElements() > REPORT_LIMIT) {

        }
    }

}
