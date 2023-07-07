package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка "Войти в аккаунт"
    private final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Вкладка "Булки"
    private final By bunsButton = By.xpath(".//span[text()='Булки']");
    //Вкладка "Соусы"
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");
    //Вкладка "Начинки"
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    //Выбранный элемент
    private final By chooseElement = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");
    //Кнопка "Оформить заказ"
    private final By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }
    public String getChooseElement() {
        return driver.findElement(chooseElement).getText();
    }

    public String getTextCreateOrderButton() {
        return driver.findElement(createOrderButton).getText();
    }

}