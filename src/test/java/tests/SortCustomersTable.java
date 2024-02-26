package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerCustomersTablePage;

@Epic("Тест ID 2")
public class SortCustomersTable extends BaseTest{
    @Test(description = "Сортировка клиентов в таблице по имени в алфавитном порядке ")
    @Feature("Сортировка клиентов в таблице по имени в алфавитном порядке ")
    public void sortCustomersTableByFName(){

        MainManagerHeader mainManagerHeader = new MainManagerHeader(driver);
        ManagerCustomersTablePage managerCustomersTablePage = new ManagerCustomersTablePage(driver);
        Assert.assertEquals(driver.getTitle(),"XYZ Bank");
        mainManagerHeader.openCustomersTable();
        managerCustomersTablePage.sortByFirstName();

    }

}
