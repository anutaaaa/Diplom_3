package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    WebDriver driver;

    //Поле "Email"
    private final By inputEmail = By.xpath(".//*[@type='text']");
    //Поле "Пароль"
    private final By inputPassword = By.xpath(".//*[@type='password']");
    //Кнопка "Войти"
    private final By buttonEnter = By.xpath(".//button[text()='Войти']");
    //Заголовок "Вход"
    private final By enter = By.xpath(".//h2[text()='Вход']");

    public  PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
    public String getTextEnter() {
        return driver.findElement(enter).getText();
    }

}
