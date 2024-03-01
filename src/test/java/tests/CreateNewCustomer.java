package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerAddCustomerPage;

@Epic("Тест ID 1")
public class CreateNewCustomer extends BaseTest {
    @Test(description = "Создание нового клиента")
    @Feature("Создание нового клиента")
    public void createNewCustomer() {
        MainManagerHeader mainManagerPage = new MainManagerHeader(driver);
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        Assert.assertEquals(driver.getTitle(), "XYZ Bank");
        mainManagerPage.openFormToAddCustomer();
        managerAddCustomerPage.fillPostCodeField().fillFirstNameField().fillLastNameField().pressAddCustomerButton();
        driver.switchTo().alert().accept();
    }
}
