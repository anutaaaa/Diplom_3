package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfilePage {
    WebDriver driver;

    //Кнопка "Выход"
    private final By buttonExit = By.xpath(".//button[text()='Выход']");
    //Локатор кнопки конструктора
    private final By buttonConstructor = By.xpath(".//p[text() = 'Конструктор']");

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExitButton() {
        driver.findElement(buttonExit).click();
    }
    public void clickConstructButton() {
        driver.findElement(buttonConstructor).click();
    }



}
