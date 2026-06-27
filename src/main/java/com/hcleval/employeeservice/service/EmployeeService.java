package com.hcleval.employeeservice.service;

import com.hcleval.employeeservice.dto.ApiResponse;
import com.hcleval.employeeservice.dto.EmployeeRequest;
import com.hcleval.employeeservice.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);

    EmployeeResponse getEmployeeById(Long id);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);

    void deleteEmployee(Long id);
}
