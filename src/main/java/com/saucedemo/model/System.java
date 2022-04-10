package com.saucedemo.model;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class System
{
    private static EnvironmentSpecificConfiguration configuration;

    static
    {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        configuration = EnvironmentSpecificConfiguration.from(environmentVariables);
    }

    public static String baseUrl()
    {
        return getProperty("webdriver.base.url");
    }

    private static String getProperty(String property)
    {
        return configuration.getProperty(property);
    }
}
