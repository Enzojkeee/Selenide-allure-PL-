import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


abstract public class BaseTest {

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        //Без окна браузера
        Configuration.headless = false;
        ChromeOptions options = new ChromeOptions();
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 90000;

        SelenideLogger.addListener("allure", new AllureSelenide());

    }
    @BeforeEach
    public void init(){
        setUp();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("allure");
    }

    public String getValue(String propValue) {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream("src\\test\\resources\\PerfomanceLabTest.properties");
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(propValue);
    }
}
