package com.kalinin.sprig_data.DAO;


import com.kalinin.sprig_data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
     List<Employee> findAllByName (String name);

}
