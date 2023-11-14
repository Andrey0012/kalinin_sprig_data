package com.kalinin.sprig_data.service;



import com.kalinin.sprig_data.DAO.EmployeeRepository;
import com.kalinin.sprig_data.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();

    }

    @Override
    public void saveEmployee(Employee employee) {
       employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        Employee employee=null;
        if (byId.isPresent()) {
            employee=byId.get();
        }
        return  employee;
    }


    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> allByName = employeeRepository.findAllByName(name);
        return allByName;
    }
}
