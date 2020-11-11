package com.application.dao.impl;

import com.application.dao.DepartmentsDAO;

import com.application.dao.factory.*;
import com.application.data.DepartmentData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DefaultDepartmentDAO implements DepartmentsDAO {

    @Override
    public ResultSet getAllDepartments() {
        String query = "SELECT * FROM depStudyProject.Departments";
        ResultSet rs = null;

        try
        {
            Connection connection = DBConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);

//            rs.close();
//            statement.close();
//            connection.close();

        }
        catch (SQLException e)
        {
            System.out.println("Read from database was failed");
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public void removeDepartmentDAO(String id) {
        String query = "DELETE FROM depStudyProject.Departments WHERE Id=" + "\'" + id + "\'" + ";";

        try
        {
            Connection connection = DBConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
       catch (SQLException e)
        {
            System.out.println("Remove from database was failed");
            e.printStackTrace();
        }
    }

    @Override
    public void createDepartmentDAO(Map<String, String> department) {

        System.out.println(department);
        String query = "INSERT depStudyProject.Departments (Id, DepartmentName, DepartmentCity, DepartmentBuilding, DepartmentStreet, DepartmentIndex)\n" +
                "\tvalues (\'" + department.get("id") + "\',\'" + department.get("name") + "\',\'" + department.get("city") + "\',\'" + department.get("building") + "\',\'" + department.get("street")+ "\',\'" + department.get("index") + "\')";

        try
        {
            Connection connection = DBConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e)
        {
            System.out.println("Create new department to database was failed");
            e.printStackTrace();
        }
    }
}
