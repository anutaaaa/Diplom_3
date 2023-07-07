package ru.praktikum_services.stellar_burgers;

import PageObject.PersonalAccountPage;
import PageObject.RegistrationPage;
import User.User;
import User.Constants;
import User.RandomHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import User.WebDriverHelper;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.equalTo;


public class RegistrationTest {
    private WebDriver driver;
    User user = RandomHelper.getRandomUserWithAllParams();

    @Before
    public void setup() {

        driver = WebDriverHelper.setDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverHelper.WAIT_SEC_TIMEOUT, TimeUnit.SECONDS);
        driver.get(Constants.REGISTRATION);
    }

    @Test
        public void registrationValidUser() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        registrationPage.setName(user.getName());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPassword(user.getPassword());
        registrationPage.clickButtonRegistration();
        Assert.assertThat(personalAccountPage.getTextEnter(), equalTo("Вход"));
        }


    @Test
    public void registrationWithShortPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setName(user.getName());
        registrationPage.setEmail(user.getEmail());
        registrationPage.setPassword(RandomHelper.getRandomShortPassword());
        registrationPage.clickButtonRegistration();
        Assert.assertThat(registrationPage.getIncorrectPassword(), equalTo("Некорректный пароль"));
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
