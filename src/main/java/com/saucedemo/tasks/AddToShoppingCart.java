package com.saucedemo.tasks;

import com.saucedemo.ui.items_catalog.Catalog;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

public class AddToShoppingCart
{
    public static Performable item(String itemName)
    {
        return Task.where("{0} adds to the shopping cart " + itemName, Click.on(Button.called("Add to cart")
                .inside(PageElement.locatedBy(Catalog.ITEMS.getCssOrXPathSelector()).containingText(itemName))));
    }
}