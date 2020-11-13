package com.application.service;

import com.application.data.DepartmentData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DepartmentService {
    List<DepartmentData> getAllDepartments();
    List<DepartmentData> removeDepartment(String id);
    void createDepartment(HttpServletRequest req);
    void editDepartment(HttpServletRequest req);
    DepartmentData getDepartmentById(String id);
}
