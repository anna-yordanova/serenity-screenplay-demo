package com.saucedemo.questions;

import com.saucedemo.ui.authentication.LoginForm;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginErrorMessage
{
    public static Question<String> text()
    {
        return Text.of(LoginForm.ERROR_MESSAGE).asString();
    }
}