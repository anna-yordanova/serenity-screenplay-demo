package com.saucedemo.ui.shopping_cart;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCartContents
{
    public static final Target ITEM_NAME = Target.the("item name").locatedBy(".inventory_item_name");
    public static final Target ITEMS = Target.the("items").locatedBy(".cart_item");
    public static final Target CONTINUE_SHOPPING_BUTTON = Target.the("'Continue shopping' button").locatedBy(
            "#continue-shopping");
}
