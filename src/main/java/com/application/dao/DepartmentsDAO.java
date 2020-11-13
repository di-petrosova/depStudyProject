package com.application.dao;

import java.sql.ResultSet;
import java.util.Map;

public interface DepartmentsDAO {
    ResultSet getAllDepartments();
    void removeDepartmentDAO(String id);
    void createDepartmentDAO(Map<String, String> department);
    void editDepartmentDAO(Map<String, String> department);
    ResultSet getDepartmentForIdDAO(String id);
}
