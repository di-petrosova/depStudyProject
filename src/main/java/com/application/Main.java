package com.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static Logger LOGGER = LoggerFactory.getLogger("Main.class");

    public static void main(String[] args)
    {
        LOGGER.error("Error message");
        Hello hello = new Hello();
    }


}
