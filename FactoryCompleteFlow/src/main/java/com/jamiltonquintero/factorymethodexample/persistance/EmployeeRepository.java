package com.jamiltonquintero.factorymethodexample.persistance;

import com.jamiltonquintero.factorymethodexample.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
