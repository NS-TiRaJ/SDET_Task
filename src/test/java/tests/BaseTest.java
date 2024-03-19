package tests;

import helpers.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/**
*Класс базовой конфигурации вебдрайвера
 * */
public class BaseTest {
    protected WebDriver driver;

    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());
    /**
     * Общие настройки для Chrome драйвера
     **/
    @BeforeMethod ()
    public void setUpChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        System.setProperty(config.driverProperty(),config.driverPath());
        driver = new ChromeDriver();
        driver.get(config.url());

    }

    /**
     * Метод закрытия драйвера
     **/
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
