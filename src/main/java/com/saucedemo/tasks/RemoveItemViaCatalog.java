package com.saucedemo.tasks;

import com.saucedemo.ui.items_catalog.Catalog;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

public class RemoveItemViaCatalog
{
    public static Performable named(String itemName)
    {
        return Task.where("{0} removes from the shopping cart " + itemName, Click.on(Button.called("Remove")
                .inside(PageElement.locatedBy(Catalog.ITEMS.getCssOrXPathSelector()).containingText(itemName))));
    }
}
