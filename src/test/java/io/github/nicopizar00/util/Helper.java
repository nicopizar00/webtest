package io.github.nicopizar00.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
    private static Helper helper;

    @Getter
    private static WebDriver driver;

    private Helper() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static void setUpDriver() {
        if (helper == null) helper = new Helper();
    }

    public static void tearDown() {
        if (driver != null) driver.quit();
        helper = null;
    }
}
