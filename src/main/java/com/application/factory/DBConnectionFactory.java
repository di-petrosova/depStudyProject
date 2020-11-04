package com.application.factory;

import com.application.service.PropertyService;
import com.application.service.impl.DefaultPropertyService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionFactory
{
    private static PropertyService propertyService = new DefaultPropertyService();

    public static Connection createConnection() throws SQLException
    {
        String url = propertyService.getString("URL");
        String user = propertyService.getString("USER");
        String password = propertyService.getString("PASSWORD");
        return DriverManager.getConnection(url, user, password);
    }
}
