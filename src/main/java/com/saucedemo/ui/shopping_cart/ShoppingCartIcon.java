package com.saucedemo.ui.shopping_cart;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartIcon
{
    public static final Target LINK = Target.the("shopping cart icon").locatedBy(".shopping_cart_link");
    public static final Target BADGE = Target.the("shopping cart badge").locatedBy(".shopping_cart_badge");
}
