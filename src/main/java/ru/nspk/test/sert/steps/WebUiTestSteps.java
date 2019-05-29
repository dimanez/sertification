package ru.nspk.test.sert.steps;

import cucumber.api.java.ru.Допустим;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import ru.nspk.test.sert.UtilsDriver;
import ru.nspk.test.sert.pages.CpvtPage;
import ru.nspk.test.sert.pages.LoginPage;

import java.lang.reflect.Type;
import java.util.Map;

public class WebUiTestSteps {
    private LoginPage loginPage;
    private CpvtPage cpvtPage;
    @Допустим("открыта страница авторизации")
    public void openLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(UtilsDriver.initDriver());
    }

    @Допустим("в поле Email введено {string}")
    public void inputEmail(String login) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.inputLogin(login);
    }

    @Допустим("в поле Пароль введено {string}")
    public void inputPassword(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.inputPassword(password);
    }

    @Тогда("нажата кнопка Войти")
    public void clickLoginButton() throws InterruptedException {
        cpvtPage = loginPage.authorization();
        Thread.sleep(2000);
    }

    @Допустим("выбрано поле Персо-профили")
    public void selectFieldProfiles() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        cpvtPage.clickOnMenuProfiles();
    }

    @Допустим("нажата кнопка Создать персо-профиль")
    public void pressButtonNewProfiles() {
        // Write code here that turns the phrase above into concrete actions
        cpvtPage.clickButtonNewProfiles();
    }

    @Допустим("заполнить селекты <селект>, <значение>")
    public void selects(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        Map map = dataTable.asMap(String.class, String.class);
        cpvtPage.clickSelects("Группа продуктов", map.get("Группа продуктов").toString());
        cpvtPage.clickSelects("Продукт", map.get("Продукт").toString());
        cpvtPage.clickSelects("Интерфейс приложения МИР", map.get("Интерфейс приложения МИР").toString());
        cpvtPage.clickSelects("Форм-фактор", map.get("Форм-фактор").toString());
        cpvtPage.clickSelects("Целевая валюта", map.get("Целевая валюта").toString());
    }

    @Допустим("нажата поле Подтверждение данных")
    public void dataConfirm() {
        // Write code here that turns the phrase above into concrete actions
        cpvtPage.selectDataConfirm();
    }

    @Тогда("нажата кнопка Создать профиль")
    public void clickCreateNewProfiles() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        cpvtPage.clickCreateNewProfiles();
        Thread.sleep(3000);
    }

    @Затем("нажата кнопка Список профилей")
    public void clickProfilesList() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        cpvtPage.clickProfilesList();
        Thread.sleep(1000);
    }

    @Допустим("отфильтровать таблицу по полю Имя профиля со значением {string}")
    public void searchFiled(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        cpvtPage.profileIntoSearchField(string);
    }

    @Допустим("проверяем что в таблице не пустой список")
    public void checkProfilesList() {
        // Write code here that turns the phrase above into concrete actions
        Boolean list = cpvtPage.getDriver().findElement(By.xpath("//div[@class='p-grid ui-commontable-tr ng-star-inserted']")).isDisplayed();
        Assert.assertEquals(list, true);
        cpvtPage.getDriver().close();
    }
}
