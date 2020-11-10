package com.application.service.impl;

import com.application.dao.DepartmentsDAO;
import com.application.dao.impl.DefaultDepartmentDAO;
import com.application.data.DepartmentData;
import com.application.service.DepartmentService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDepartmentService implements DepartmentService
{

    private DepartmentsDAO departmentsDAO = new DefaultDepartmentDAO();



    @Override
    public List<DepartmentData> getAllDepartments()
    {
        List<DepartmentData> departmentsList = new ArrayList<>();
        ResultSet allDepartments = departmentsDAO.getAllDepartments();

        System.out.println(departmentsDAO.getAllDepartments());
        try
        {
            while (allDepartments.next())
            {
                DepartmentData dep = new DepartmentData();
                dep.setDepId(allDepartments.getInt(1));
                dep.setDepName(allDepartments.getString(2));
                dep.setDepCity(allDepartments.getString(3));
                dep.setDepBuilding(allDepartments.getString(4));
                dep.setDepStreet(allDepartments.getString(5));
                dep.setDepIndex(allDepartments.getString(6));
                departmentsList.add(dep);
            }
        }
        catch (SQLException e)
        {

        }
        return departmentsList;
    }

}
