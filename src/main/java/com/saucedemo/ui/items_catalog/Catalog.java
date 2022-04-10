package com.saucedemo.ui.items_catalog;

import net.serenitybdd.screenplay.targets.Target;

public class Catalog
{
    public static final Target ITEMS = Target.the("items list").locatedBy(".inventory_item");
    public static final Target ADD_TO_CART_BUTTON = Target.the("'Add to cart' button").locatedBy(".inventory_item");
}
