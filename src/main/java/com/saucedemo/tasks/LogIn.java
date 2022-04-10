package com.saucedemo.tasks;

import com.saucedemo.model.User;
import com.saucedemo.ui.authentication.LoginForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LogIn
{
    public static Performable withCredentials(String username, String password)
    {
        return login(username, password);
    }

    public static Performable as(Actor actor)
    {
        User user = User.valueOf(actor.getName().toUpperCase());
        return login(user.getUserName(), user.getUserPassword());
    }

    private static Performable login(String username, String password)
    {
        return Task.where("{0} fills logins in",
                Enter.theValue(username).into(LoginForm.USERNAME),
                Enter.theValue(password).into(LoginForm.PASSWORD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }
}
