package com.saucedemo.tasks;

import com.saucedemo.model.System;
import com.saucedemo.ui.shopping_cart.ShoppingCartIcon;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo
{
    public static Performable theLoginPage()
    {
        return Task.where("{0} opens the Home page", Open.url(System.baseUrl()));
    }

    public static Performable theShoppingCart()
    {
        return Task.where("{0} opens the Shopping cart", Click.on(ShoppingCartIcon.LINK));
    }
}