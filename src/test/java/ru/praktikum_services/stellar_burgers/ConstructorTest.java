package ru.praktikum_services.stellar_burgers;

import PageObject.MainPage;
import User.Constants;
import User.WebDriverHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class ConstructorTest{
    WebDriver driver;

    @Before
    public void init() {
        driver = WebDriverHelper.setDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverHelper.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
        driver.get(Constants.BASE_URI);
}

    @Test
    public void switchOnBunsList() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getChooseElement());
    }

    @Test
    public void switchOnSaucesList() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getChooseElement());
    }

    @Test
    public void switchOnFillingsList() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        Assert.assertEquals("Начинки", mainPage.getChooseElement());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
