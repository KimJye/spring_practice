package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
