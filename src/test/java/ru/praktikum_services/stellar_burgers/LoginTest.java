package ru.praktikum_services.stellar_burgers;

import PageObject.MainPage;
import PageObject.PersonalAccountPage;
import PageObject.RegistrationPage;
import User.User;
import User.Constants;
import User.RandomHelper;
import User.UserHelper;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import User.WebDriverHelper;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    private WebDriver driver;
    User user= RandomHelper.getRandomUserWithAllParams();;
    String accessToken;

    @Before
    public void setup() {

        driver = WebDriverHelper.setDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverHelper.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
        Response response = UserHelper.createUser(user);
        accessToken = response.then().extract().path("accessToken").toString();
    }

    @Test

    public void enterOnMainPage() {
        driver.get(Constants.BASE_URI);
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickEnterButton();
        personalAccountPage.setEmail(user.getEmail());
        personalAccountPage.setPassword(user.getPassword());
        personalAccountPage.clickButtonEnter();
        Assert.assertThat(mainPage.getTextCreateOrderButton(), equalTo("Оформить заказ"));
    }

    @Test
    public void enterOnPersonalProfilePage() {
        driver.get(Constants.BASE_URI);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.setEmail(user.getEmail());
        personalAccountPage.setPassword(user.getPassword());
        personalAccountPage.clickButtonEnter();
        Assert.assertThat(mainPage.getTextCreateOrderButton(), equalTo("Оформить заказ"));
    }

    @Test

    public void enterFromRegistrationForm() {
        driver.get(Constants.REGISTRATION);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        registrationPage.clickButtonEnter();
        personalAccountPage.setEmail(user.getEmail());
        personalAccountPage.setPassword(user.getPassword());
        personalAccountPage.clickButtonEnter();
        Assert.assertThat(mainPage.getTextCreateOrderButton(), equalTo("Оформить заказ"));
    }

    @Test

    public void enterFromRecoveryPasswordPage() {
        driver.get(Constants.FOGOTPASSWORD);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        registrationPage.clickButtonEnter();
        personalAccountPage.setEmail(user.getEmail());
        personalAccountPage.setPassword(user.getPassword());
        personalAccountPage.clickButtonEnter();
        Assert.assertThat(mainPage.getTextCreateOrderButton(), equalTo("Оформить заказ"));
    }

    @After
    public void teardown() {
        UserHelper.deleteUser(accessToken);
        driver.quit();
    }
}
