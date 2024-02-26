package tests;

import helpers.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        System.setProperty(config.driverProperty(),config.driverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
