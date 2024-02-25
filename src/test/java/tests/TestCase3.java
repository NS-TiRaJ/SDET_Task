package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerCustomersTablePage;

@Epic("Тест кейс 2")
public class TestCase3 extends BaseTest{
    @Test(description = "Удаление клиента из таблицы")
    @Feature("Удаление клиента из таблицы")
    public void testCase3(){
        MainManagerHeader mainManagerHeader = new MainManagerHeader(driver);
        ManagerCustomersTablePage managerCustomersTablePage = new ManagerCustomersTablePage(driver);
        mainManagerHeader.openCustomersTable();
        managerCustomersTablePage.deleteCustomerByAvrgNameValue();
    }

}
