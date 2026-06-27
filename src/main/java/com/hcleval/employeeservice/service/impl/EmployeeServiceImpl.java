package com.hcleval.employeeservice.service.impl;

import com.hcleval.employeeservice.dto.ApiResponse;
import com.hcleval.employeeservice.dto.EmployeeRequest;
import com.hcleval.employeeservice.dto.EmployeeResponse;
import com.hcleval.employeeservice.entity.Employee;
import com.hcleval.employeeservice.mapper.EmployeeMapper;
import com.hcleval.employeeservice.repository.EmployeeRepository;
import com.hcleval.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public ApiResponse<EmployeeResponse> createEmployee(EmployeeRequest request) {
        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Employee with email already exists.");
        }

        Employee employee = employeeMapper.toEntity(request);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponse response = employeeMapper.toResponse(savedEmployee);

        return ApiResponse.<EmployeeResponse>builder()
                .success(true)
                .message("Employee created successfully")
                .data(response)
                .build();
    }

    @Override
    public ApiResponse<EmployeeResponse> getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        EmployeeResponse response = employeeMapper.toResponse(employee);

        return ApiResponse.<EmployeeResponse>builder()
                .success(true)
                .message("Employee fetched successfully")
                .data(response)
                .build();
    }

    @Override
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {
        List<EmployeeResponse> employees = employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponse)
                .toList();

        return ApiResponse.<List<EmployeeResponse>>builder()
                .success(true)
                .message("Employees fetched successfully")
                .data(employees)
                .build();
    }

    @Override
    public ApiResponse<EmployeeResponse> updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employeeMapper.updateEmployeeFromRequest(request, employee);

        Employee updatedEmployee = employeeRepository.save(employee);

        EmployeeResponse response = employeeMapper.toResponse(updatedEmployee);

        return ApiResponse.<EmployeeResponse>builder()
                .success(true)
                .message("Employee updated successfully")
                .data(response)
                .build();
    }

    @Override
    public ApiResponse<Void> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employeeRepository.delete(employee);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Employee deleted successfully")
                .build();
    }
}
