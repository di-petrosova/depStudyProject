package com.application.dao.factory;

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
//        String url = propertyService.getString("URL");
//        String user = propertyService.getString("USER");
//        String password = propertyService.getString("PASSWORD");
        String url = propertyService.getStringOrDefault("URL", "jdbc:mysql://localhost/depStudyProject");
        String user = propertyService.getStringOrDefault("USER", "root");
        String password = propertyService.getStringOrDefault("PASSWORD", "123456");

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
        return DriverManager.getConnection(url, user, password);
    }
}
