package io.github.nicopizar00.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        if (!Objects.equals(driver.getCurrentUrl(), "https://www.demoblaze.com/"))
            throw new IllegalStateException("Not in Home Page");
        firstProductLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/div[1]/div/a")));
    }

    WebElement firstProductLink;

    /**
     * Click the first product to purchase it.
     *
     * @return Product Page
     */
    public ProductPage clickFirstProduct() {
        firstProductLink.click();
        return new ProductPage(driver);
    }
}
