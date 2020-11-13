package com.application.service.impl;

import com.application.dao.DepartmentsDAO;
import com.application.dao.impl.DefaultDepartmentDAO;
import com.application.data.DepartmentData;
import com.application.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultDepartmentService implements DepartmentService
{

    private DepartmentsDAO departmentsDAO = new DefaultDepartmentDAO();
    private static Logger LOG  = LoggerFactory.getLogger(DefaultDepartmentService.class);

    @Override
    public List<DepartmentData> getAllDepartments()
    {
        List<DepartmentData> departmentsList = new ArrayList<>();
        ResultSet resultSet = departmentsDAO.getAllDepartments();

        System.out.println(departmentsDAO.getAllDepartments());
        try
        {
            while (resultSet.next())
            {
                DepartmentData departmentData = new DepartmentData();
                departmentData.setDepId(resultSet.getInt(1));
                departmentData.setDepName(resultSet.getString(2));
                departmentData.setDepCity(resultSet.getString(3));
                departmentData.setDepBuilding(resultSet.getString(4));
                departmentData.setDepStreet(resultSet.getString(5));
                departmentData.setDepIndex(resultSet.getString(6));
                departmentsList.add(departmentData);
            }
        }
        catch (SQLException e)
        {
            LOG.error("Select all departments was failed");
        }
        return departmentsList;
    }

    @Override
    public DepartmentData getDepartmentById(String idToEdit)
    {
        DepartmentData departmentData = new DepartmentData();

        ResultSet resultSet = departmentsDAO.getDepartmentForIdDAO(idToEdit);
        try
        {
            resultSet.next();
            departmentData.setDepId(resultSet.getInt(1));
            departmentData.setDepName(resultSet.getString(2));
            departmentData.setDepCity(resultSet.getString(3));
            departmentData.setDepBuilding(resultSet.getString(4));
            departmentData.setDepStreet(resultSet.getString(5));
            departmentData.setDepIndex(resultSet.getString(6));
        }
        catch (SQLException e)
        {
            LOG.error("Get department by its id was failed");
        }

        return departmentData;
    }

    @Override
    public List<DepartmentData> removeDepartment(String id)
    {
        departmentsDAO.removeDepartmentDAO(id);

        return getAllDepartments();
    }

    @Override
    public void createDepartment(HttpServletRequest req)
    {
        Map<String, String> newDepartment = new HashMap<>();
        newDepartment.put("id", req.getParameter("id"));
        newDepartment.put("name", req.getParameter("name"));
        newDepartment.put("city", req.getParameter("city"));
        newDepartment.put("building", req.getParameter("building"));
        newDepartment.put("street", req.getParameter("street"));
        newDepartment.put("index", req.getParameter("index"));

        departmentsDAO.createDepartmentDAO(newDepartment);
    }

    @Override
    public void editDepartment(HttpServletRequest req)
    {
        Map<String, String> editedDepartment = new HashMap<>();
        editedDepartment.put("id", req.getParameter("id"));
        editedDepartment.put("name", req.getParameter("name"));
        editedDepartment.put("city", req.getParameter("city"));
        editedDepartment.put("building", req.getParameter("building"));
        editedDepartment.put("street", req.getParameter("street"));
        editedDepartment.put("index", req.getParameter("index"));

        departmentsDAO.editDepartmentDAO(editedDepartment);
    }
}
