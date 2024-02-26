package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainManagerHeader;
import pages.ManagerCustomersTablePage;

@Epic("Тест ID 3")
public class DeleteCustomer extends BaseTest{
    @Test(description = "Удаление клиента из таблицы")
    @Feature("Удаление клиента из таблицы")
    public void dltCustomerByAvgFName (){
        MainManagerHeader mainManagerHeader = new MainManagerHeader(driver);
        ManagerCustomersTablePage managerCustomersTablePage = new ManagerCustomersTablePage(driver);
        Assert.assertEquals(driver.getTitle(),"XYZ Bank");
        mainManagerHeader.openCustomersTable();
        managerCustomersTablePage.deleteCustomerByAvrgNameValue();
    }

}
