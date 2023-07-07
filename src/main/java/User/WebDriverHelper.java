package User;


import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {
    public static final long WAIT_SEC_TIMEOUT = 10;

    public static WebDriver setDriver() {
        //Тесты в Chrome
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

        //Тесты в  Yandex
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
//        return new ChromeDriver(options);
    }

}
