package io.github.nicopizar00.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.nicopizar00.model.Payment;
import io.github.nicopizar00.page.CartPage;
import io.github.nicopizar00.page.HomePage;
import io.github.nicopizar00.page.ProductPage;
import io.github.nicopizar00.util.Helper;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseDefinitios {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        Helper.openPage("https://www.demoblaze.com/");
        homePage = new HomePage(Helper.getDriver());
    }

    @When("I select a product")
    public void i_select_a_product() {
        productPage = homePage.clickFirstProduct();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        Alert alert = productPage.addToCart();
        alert.accept();
    }

    @When("I go to the cart")
    public void i_go_to_the_cart() {
        cartPage = productPage.goToCart();
    }

    @When("I place an order")
    public void i_place_an_order() {
        cartPage.clickPlaceOrder();
    }

    @When("I fill in my personal information with name {string}, country {string}, city {string}, credit card {string}, month {string}, and year {string}")
    public void i_fill_in_my_personal_information(
            String name,
            String country,
            String city,
            String creditCard,
            String month,
            String year) {
        Payment payment = new Payment(name, country, city, creditCard, month, year); //this does not works

        assertTrue(cartPage.completeForm(payment));
    }

    @When("I complete the purchase")
    public void i_complete_the_purchase() {
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        assertEquals(cartPage.getOrderMessage().getText(),
                "Thank you for your purchase!",
                "Order Message is not ok.");
        assertFalse(cartPage.getOrderDetails().getText().isEmpty(),
                "The Order Details does not contain data.");

    }
}
