package com.application.service;

import com.application.data.DepartmentData;

import java.util.List;

public interface DepartmentService {
    List<DepartmentData> getAllDepartments();
    List<DepartmentData> removeDepartment(String id);
}
