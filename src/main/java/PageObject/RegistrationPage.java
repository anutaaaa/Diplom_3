package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    //Поле "Имя"
    private final By inputName = By.xpath("//div/form/fieldset[1]//input[@name='name']");
    //Поле "Email"
    private final By inputEmail = By.xpath("//div/form/fieldset[2]//input[@name='name']");
    //Поле "Пароль"
    private final By inputPassword = By.xpath("//div/form/fieldset[3]//input[@name='Пароль']");
    //Кнопка "Зарегистрироваться"
    private final By buttonRegistration = By.xpath(".//*[text()='Зарегистрироваться']");
    //Кнопка "Войти"
    private final By buttonEnter = By.className("Auth_link__1fOlj");
    //Ошибка "Некорректный пароль"
    private final By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
    public String getIncorrectPassword() {
        return driver.findElement(incorrectPassword).getText();
    }
}