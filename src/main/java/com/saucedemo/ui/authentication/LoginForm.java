package com.saucedemo.ui.authentication;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm
{
    public static final Target USERNAME = Target.the("username field").located(By.id("user-name"));
    public static final Target PASSWORD = Target.the("password field").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("Login button").located(By.id("login-button"));
    public static final Target ERROR_MESSAGE = Target.the("error message")
            .located(By.cssSelector("h3[data-test='error']"));
}