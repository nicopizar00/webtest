package io.github.nicopizar00.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
        if (!Objects.requireNonNull(driver.getCurrentUrl()).contains("prod.html"))
            throw new IllegalStateException("Not in Product Page.");
        btnAddToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-success btn-lg']")));
    }

    WebElement btnAddToCart;

    @FindBy(id = "cartur")
    WebElement navItemCart;

    /**
     * Clicks Add to Cart button.
     *
     * @return boolean true if completes ok.
     */
    public Alert addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
        btnAddToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    /**
     * Click Go to Cart nav item (at the top of the website)
     *
     * @return Cart Page.
     */
    public CartPage goToCart() {
        navItemCart.click();
        return new CartPage(driver);
    }
}
