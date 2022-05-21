package com.saucedemo.questions;

import com.saucedemo.ui.shopping_cart.ShoppingCartContents;
import com.saucedemo.ui.shopping_cart.ShoppingCartIcon;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class ShoppingCart
{
    public static Question<Integer> badgeCount()
    {
        return Text.of(ShoppingCartIcon.BADGE).asInteger();
    }

    public static Question<Collection<String>> items()
    {
        return Text.ofEach(ShoppingCartContents.ITEM_NAME);
    }
}