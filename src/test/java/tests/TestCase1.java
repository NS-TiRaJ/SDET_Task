package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerAddCustomerPage;

@Epic("Тест 1")
public class TestCase1 extends BaseTest{
    @Test(description = "Создание нового клиента ")
    @Feature("Создание нового клиента ")
    public void testCase1(){
        MainManagerHeader mainManagerPage = new MainManagerHeader(driver);
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        mainManagerPage.openFormToAddCustomer();
        managerAddCustomerPage.fillPostCodeField().fillFirstNameField().fillLastNameField().pressAddCustomerButton();
        driver.switchTo().alert().accept();
    }
}
