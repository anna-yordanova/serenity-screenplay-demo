package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.ShoppingCart;
import com.saucedemo.tasks.AddToShoppingCart;
import com.saucedemo.tasks.NavigateTo;
import com.saucedemo.tasks.RemoveItemViaCatalog;
import com.saucedemo.tasks.RemoveItemViaShoppingCart;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ShoppingCartStepDefinitions
{
    private List<String> addedItems;
    private List<String> removedItems;

    @When("^(?:he|she) (?:chooses|has chosen) the following items:$")
    public void addItemsToShoppingCart(List<String> itemNames)
    {
        itemNames.forEach(itemName -> theActorInTheSpotlight().attemptsTo(AddToShoppingCart.item(itemName)));
        addedItems = itemNames;
    }

    @Then("the shopping cart count should be {int}")
    public void assertShoppingCartItemsCount(int itemsCount)
    {
        theActorInTheSpotlight().attemptsTo(Ensure.that(ShoppingCart.badgeCount()).isEqualTo(itemsCount));
    }

    @Then("^the (?:item|items) should be (?:listed in|removed from) the shopping cart$")
    public void assertItemsAreListedInShoppingCart()
    {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theShoppingCart(),
                Ensure.that(ShoppingCart.items()).containsExactlyElementsFrom(expectedItems(addedItems, removedItems)));
    }

    @When("{actor} removes the following item(s) via catalog overview")
    public void removeItemFromCatalog(Actor actor, List<String> itemNames)
    {
        itemNames.forEach(itemName -> actor.attemptsTo(RemoveItemViaCatalog.named(itemName)));
        removedItems = itemNames;
    }

    @When("{actor} removes the following item via shopping cart")
    public void removeItemViaShoppingCart(Actor actor, List<String> itemNames)
    {
        actor.attemptsTo(NavigateTo.theShoppingCart());
        itemNames.forEach(itemName -> actor.attemptsTo(RemoveItemViaShoppingCart.named(itemName)));
        removedItems = itemNames;
    }

    private List<String> expectedItems(List<String> addedItems, List<String> removedItems)
    {
        List<String> expectedItems = new ArrayList<>(addedItems);

        if (removedItems != null)
        {
            expectedItems.removeAll(removedItems);
        }

        return expectedItems;
    }
}