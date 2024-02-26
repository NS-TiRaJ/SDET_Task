package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerAddCustomerPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Тест ID 1")
public class CreateNewCustomer extends BaseTest{
    @Test(description = "Создание нового клиента ")
    @Feature("Тестовый сценарий 1")
    public void createNewCustomer(){
        MainManagerHeader mainManagerPage = new MainManagerHeader(driver);
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Assert.assertEquals(driver.getTitle(),"XYZ Bank");
        mainManagerPage.openFormToAddCustomer();
        managerAddCustomerPage.fillPostCodeField().fillFirstNameField().fillLastNameField().pressAddCustomerButton();
        driver.switchTo().alert().accept();
    }
}
