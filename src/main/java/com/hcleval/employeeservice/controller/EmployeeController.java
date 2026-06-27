package com.hcleval.employeeservice.controller;

import com.hcleval.employeeservice.dto.ApiResponse;
import com.hcleval.employeeservice.dto.EmployeeRequest;
import com.hcleval.employeeservice.dto.EmployeeResponse;
import com.hcleval.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(request));
    }

    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponse> getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public ApiResponse<EmployeeResponse> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest request) {

        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteEmployee(
            @PathVariable Long id) {

        return employeeService.deleteEmployee(id);
    }

}
