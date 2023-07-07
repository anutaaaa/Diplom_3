package ru.praktikum_services.stellar_burgers;

import PageObject.MainPage;
import PageObject.PersonalAccountPage;
import PageObject.UserProfilePage;
import User.User;
import User.UserHelper;
import User.RandomHelper;
import User.Constants;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import User.WebDriverHelper;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.equalTo;

public class PersonalAccountTest {

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
    public void logoutFromPersonalAccount() {
        driver.get(Constants.BASE_URI);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.setEmail(user.getEmail());
        personalAccountPage.setPassword(user.getPassword());
        personalAccountPage.clickButtonEnter();
        mainPage.clickPersonalAccountButton();
        userProfilePage.clickExitButton();
        Assert.assertThat(personalAccountPage.getTextEnter(), equalTo("Вход"));
    }

    @Test
    public void transitToConstructorFromPersonalAccount() {
        driver.get(Constants.BASE_URI);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        MainPage mainPage = new MainPage(driver);
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.setEmail(user.getEmail());
        personalAccountPage.setPassword(user.getPassword());
        personalAccountPage.clickButtonEnter();
        mainPage.clickPersonalAccountButton();
        userProfilePage.clickConstructButton();
        Assert.assertThat(mainPage.getTextCreateOrderButton(), equalTo("Оформить заказ"));
    }


@After
public void teardown() {
    UserHelper.deleteUser(accessToken);
    driver.quit();
}

}
