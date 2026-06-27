package com.hcleval.employeeservice.service;

import com.hcleval.employeeservice.dto.ApiResponse;
import com.hcleval.employeeservice.dto.EmployeeRequest;
import com.hcleval.employeeservice.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    ApiResponse<EmployeeResponse> createEmployee(EmployeeRequest request);

    ApiResponse<EmployeeResponse> getEmployeeById(Long id);

    ApiResponse<List<EmployeeResponse>> getAllEmployees();

    ApiResponse<EmployeeResponse> updateEmployee(Long id, EmployeeRequest request);

    ApiResponse<Void> deleteEmployee(Long id);
}
