package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerCustomersTablePage;

@Epic("Тест 2")
public class TestCase2 extends BaseTest{
    @Test(description = "Сортировка клиентов в таблице по имени в алфавитном порядке ")
    @Feature("Сортировка клиентов в таблице по имени в алфавитном порядке ")
    public void testCase2(){
        MainManagerHeader mainManagerHeader = new MainManagerHeader(driver);
        ManagerCustomersTablePage managerCustomersTablePage = new ManagerCustomersTablePage(driver);
        mainManagerHeader.openCustomersTable();
        managerCustomersTablePage.sortByFirstName();

    }

}
