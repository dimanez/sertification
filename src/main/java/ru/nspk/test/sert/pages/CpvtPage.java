package ru.nspk.test.sert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CpvtPage {

    private final WebDriver driver;

    @FindBy(xpath = "//p-accordiontab[@id='sidebar_menu_profiles']")
    private WebElement menuProfiles;

    @FindBy(xpath = "//span[text()='Создать персо-профиль']")
    private WebElement buttonNewProfiles;

    @FindBy(xpath = "//span[text()='Подтверждение данных']")
    private WebElement dataConfirm;

    @FindBy(xpath = "//span[@class='ui-button-text ui-clickable']")
    private WebElement createNewProfiles;

    @FindBy(xpath = "//input[@placeholder='Имя профиля']")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()='Список профилей']")
    private WebElement profilesList;


    public CpvtPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnMenuProfiles(){
        menuProfiles.click();
    }

    public void clickButtonNewProfiles(){
        buttonNewProfiles.click();
    }

    public void selectDataConfirm(){
        dataConfirm.click();
    }

    public void clickCreateNewProfiles(){
        createNewProfiles.click();
    }

    public void clickProfilesList(){
        profilesList.click();
    }

    public void profileIntoSearchField(String profileName) throws InterruptedException {
        searchField.sendKeys(profileName);
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickSelects(String name, String element) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//p[@class='panel-text topic mb16' and text()='"+name+"']/following-sibling::p-dropdown")).click();
        driver.findElement(By.xpath("//li[@aria-label='" + element + "']")).click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
