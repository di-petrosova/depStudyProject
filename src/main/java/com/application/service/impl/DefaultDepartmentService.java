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
    private static Logger LOG = LoggerFactory.getLogger(DefaultDepartmentService.class);

    @Override
    public List<DepartmentData> getAllDepartments()
    {
        ResultSet resultSet = departmentsDAO.getAllDepartments();
        List<DepartmentData> departmentData = convertToDepartmentList(resultSet);
        return departmentData;
    }

    private List<DepartmentData> convertToDepartmentList(ResultSet resultSet) {
        List<DepartmentData> departmentsList = new ArrayList<>();

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
        ResultSet resultSet = departmentsDAO.getDepartmentForIdDAO(idToEdit);
        List<DepartmentData> departmentDataList = convertToDepartmentList(resultSet);
        if(departmentDataList.isEmpty()) {
            return null;
        }

        return departmentDataList.get(0);
    }

    @Override
    public String getRandomId()
    {
        String randomId;
        int intId;
        do
        {
            intId = (int) (Math.random() * 10000);
            randomId = String.valueOf(intId);
        }
        while (departmentsDAO.checkExistingDepartmentId(randomId));
        return randomId;
    }

    @Override
    public List<DepartmentData> removeDepartment(String id)
    {
        departmentsDAO.removeDepartmentDAO(id);

        return getAllDepartments();
    }


    private Map<String, String> convertRequestToMap(HttpServletRequest req) {
        Map<String, String> department = new HashMap<>();
        department.put("id", req.getParameter("id"));
        department.put("name", req.getParameter("name"));
        department.put("city", req.getParameter("city"));
        department.put("building", req.getParameter("building"));
        department.put("street", req.getParameter("street"));
        department.put("index", req.getParameter("index"));

        return department;
    }

    @Override
    public void createDepartment(HttpServletRequest req)
    {
        Map<String, String> newDepartment = convertRequestToMap(req);
        newDepartment.put("id", getRandomId());
        departmentsDAO.createDepartmentDAO(newDepartment);
    }

    @Override
    public void editDepartment(HttpServletRequest req)
    {
        departmentsDAO.editDepartmentDAO(convertRequestToMap(req));
    }
}
