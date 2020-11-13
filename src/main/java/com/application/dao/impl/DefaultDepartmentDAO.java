package com.application.dao.impl;

import com.application.dao.DepartmentsDAO;

import com.application.dao.factory.*;
import com.application.data.DepartmentData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DefaultDepartmentDAO implements DepartmentsDAO {

    private static Logger LOG = LoggerFactory.getLogger(DefaultDepartmentDAO.class);

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
            LOG.error("Read from database was failed");
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
            LOG.error("Remove from database was failed");
        }
    }

    @Override
    public void createDepartmentDAO(Map<String, String> department) {

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
            LOG.error("Create new department to database was failed");
        }
    }

    @Override
    public void editDepartmentDAO(Map<String, String> department) {
        String query = "UPDATE depStudyProject.Departments SET Id = \'" + department.get("id") + "\', DepartmentName = \'" + department.get("name") + "\', DepartmentCity = \'" + department.get("city") + "\', DepartmentBuilding = \'" + department.get("building")+ "\', DepartmentStreet = \'" + department.get("street") + "\', DepartmentIndex = \'" + department.get("index") + "\'" + " WHERE id='"+ department.get("id")+"\'";

        try
        {
            Connection connection = DBConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e)
        {
            LOG.error("Edit department was failed");
        }
    }

    @Override
    public ResultSet getDepartmentForIdDAO(String id) {
        String query = "SELECT * FROM depStudyProject.Departments WHERE id=\'" + id + "\'";
        ResultSet rs = null;

        try
        {
            Connection connection = DBConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);

        }
        catch (SQLException e)
        {
            LOG.error("Read from database was failed", e);

        }
        return rs;
    }


}
