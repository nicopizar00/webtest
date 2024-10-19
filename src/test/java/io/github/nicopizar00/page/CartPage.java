package io.github.nicopizar00.page;

import io.github.nicopizar00.model.Payment;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@class='btn btn-success']")
    WebElement btnPlaceOrder;

    WebElement orderModal;
    WebElement txtName;
    WebElement txtCountry;
    WebElement txtCity;
    WebElement txtCard;
    WebElement txtMonth;
    WebElement txtYear;
    WebElement btnPurchase;
    WebElement alertPurchaseOrder;

    @Getter
    WebElement orderMessage;
    @Getter
    WebElement orderDetails;

    public CartPage(WebDriver driver) {
        super(driver);
        if (!Objects.requireNonNull(driver.getCurrentUrl()).contains("cart.html"))
            throw new IllegalStateException("Not in Cart Page");
    }

    /**
     * Clicks Place Order button
     *
     * @return Place Order Page
     */
    public Boolean clickPlaceOrder() {
        btnPlaceOrder.click();
        orderModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModalLabel")));
        if (orderModal != null) {
            txtName = driver.findElement(By.id("name"));
            txtCountry = driver.findElement(By.id("country"));
            txtCity = driver.findElement(By.id("city"));
            txtCard = driver.findElement(By.id("card"));
            txtMonth = driver.findElement(By.id("month"));
            txtYear = driver.findElement(By.id("year"));
            btnPurchase = driver.findElement(By.xpath("//*[@class='btn btn-primary' and text()='Purchase']"));
            return true;
        } else
            return false;
    }

    public Boolean completeForm(Payment payment) {
        txtName.sendKeys(payment.getName());
        txtCountry.sendKeys(payment.getCountry());
        txtCity.sendKeys(payment.getCity());
        txtCard.sendKeys(payment.getCreditCard());
        txtMonth.sendKeys(payment.getMonth());
        txtYear.sendKeys(payment.getYear());
        btnPurchase.click();
        alertPurchaseOrder = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='sweet-alert  showSweetAlert visible']")));
        orderMessage = alertPurchaseOrder.findElement(By.xpath("//*[text()='Thank you for your purchase!']"));
        orderDetails = alertPurchaseOrder.findElement(By.xpath("//*[@class='lead text-muted ']"));
        return true;
    }
}
