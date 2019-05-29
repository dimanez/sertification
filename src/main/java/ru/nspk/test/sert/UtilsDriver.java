package ru.nspk.test.sert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UtilsDriver {
    private static WebDriver driver;

    public static WebDriver initDriver()  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
