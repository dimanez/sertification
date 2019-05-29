package ru.nspk.test.sert.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginFiled;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class='ui-button-text ui-clickable']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("http://msk1-devcpvtapp01.unix.nspk.ru/CPVT/");
    }

    public void inputLogin(String login){
        loginFiled.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public CpvtPage authorization(){
        loginButton.click();
        return new CpvtPage(driver);
    }
}
