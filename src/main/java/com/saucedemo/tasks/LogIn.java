package com.saucedemo.tasks;

import com.saucedemo.model.User;
import com.saucedemo.ui.authentication.LoginForm;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LogIn
{
    public static Performable withCredentials(String username, String password)
    {
        return Task.where("{0} logs in with username '" + username + "' and password '" + password + "'",
                Enter.theValue(username).into(LoginForm.USERNAME),
                Enter.theValue(password).into(LoginForm.PASSWORD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }

    public static Performable withValidCredentials()
    {
        return Task.where("{0} logs in with valid credentials",
                actor -> {
                    try
                    {
                        User user = User.valueOf(actor.getName().toUpperCase());
                        actor.attemptsTo(withCredentials(user.getUserName(), user.getUserPassword()));
                    }
                    catch (IllegalArgumentException e)
                    {
                        e.printStackTrace();
                    }
                }
        );
    }
}