package com.application;

import com.application.service.impl.DefaultDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static Logger LOGGER = LoggerFactory.getLogger("Main.class");

    public static void main(String[] args)
    {
        LOGGER.info("Application started");
        DefaultDepartmentService defaultDepartmentService = new DefaultDepartmentService();
        defaultDepartmentService.getAllDepartments();
    }
}
