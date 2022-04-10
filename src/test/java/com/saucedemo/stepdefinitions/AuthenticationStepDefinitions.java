package com.saucedemo.stepdefinitions;

import com.saucedemo.model.System;
import com.saucedemo.questions.LoginErrorMessage;
import com.saucedemo.tasks.LogIn;
import com.saucedemo.tasks.NavigateTo;
import com.saucedemo.ui.items_catalog.Catalog;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AuthenticationStepDefinitions
{
    @When("{actor} is on the Login page")
    public void navigateToLoginPage(Actor actor)
    {
        actor.attemptsTo(NavigateTo.theLoginPage());
    }

    @When("{actor} attempts to login with valid credentials")
    public void login(Actor actor)
    {
        theActorInTheSpotlight().attemptsTo(LogIn.as(actor));
    }

    @When("{actor} attempts to login with username {string} and password {string}")
    public void login(Actor actor, String username, String password)
    {
        actor.attemptsTo(LogIn.withCredentials(username, password));
    }

    @When("{actor} is logged in with valid credentials")
    public void loggedInAs(Actor actor)
    {
        navigateToLoginPage(actor);
        login(actor);
    }

    @Then("the catalog should be displayed")
    public void assertCatalogIsDisplayed()
    {
        theActorInTheSpotlight().attemptsTo(Ensure.thatTheListOf(Catalog.ITEMS).isNotEmpty());
    }

    @Then("{actor} is not logged in")
    public void assertNotLoggedIn(Actor actor)
    {
        actor.attemptsTo(Ensure.thatTheCurrentPage().currentUrl().isEqualTo(System.baseUrl()));
    }

    @Then("an error message {string} is displayed")
    public void assertErrorIsDisplayed(String errorMessage)
    {
        theActorInTheSpotlight().attemptsTo(Ensure.that(LoginErrorMessage.text()).contains(errorMessage));
    }
}
