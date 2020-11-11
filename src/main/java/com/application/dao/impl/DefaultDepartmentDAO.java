package com.application.dao.impl;

import com.application.dao.DepartmentsDAO;

import com.application.dao.factory.*;
import com.application.data.DepartmentData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
