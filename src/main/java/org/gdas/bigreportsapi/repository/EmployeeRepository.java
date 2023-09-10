package org.gdas.bigreportsapi.repository;

import org.gdas.bigreportsapi.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {}
