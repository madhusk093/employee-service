package com.hcleval.employeeservice.mapper;

import com.hcleval.employeeservice.dto.EmployeeRequest;
import com.hcleval.employeeservice.dto.EmployeeResponse;
import com.hcleval.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequest request);

    EmployeeResponse toResponse(Employee employee);

    void updateEmployeeFromRequest(EmployeeRequest request,
                                   @MappingTarget Employee employee);
}
