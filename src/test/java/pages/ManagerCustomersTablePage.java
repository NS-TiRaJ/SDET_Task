package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;

import static helpers.Waiters.waitToBeClickable;
import static helpers.Waiters.waitUntilVisible;

public class ManagerCustomersTablePage {

    private final WebDriver driver;
    /**
     * Конструктор WebDriver для работы с элементами страницы
     */
    public ManagerCustomersTablePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Блок с локаторами элементов таблицы Customers
     */
    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    private WebElement searchBar;
    @FindBy (xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private WebElement tableColumnFirstName;
    @FindBy (xpath = "//a[@ng-click=\"sortType = 'lName'; sortReverse = !sortReverse\"]")
    private WebElement tableColumnLastName;
    @FindBy (xpath = "//a[@ng-click=\"sortType = 'postCd'; sortReverse = !sortReverse\"]")
    private WebElement tableColumnPostCode;
    @FindBy (xpath = "//button[@ng-click='deleteCust(cust)']")
    private WebElement buttonDeleteCustomer;

    /**
     * Блок с шагами теста
     */
    @Step ("Сортировка по имени")
    public ManagerCustomersTablePage sortByFirstName(){waitUntilVisible(driver,tableColumnFirstName);tableColumnFirstName.click();tableColumnFirstName.click();
        return this;
    }
    @Step ("Удаление клиента длинна имени которого ближе всех к среднему арифметическому всех имен")
    public ManagerCustomersTablePage deleteCustomerByAvrgNameValue(){
        waitToBeClickable(driver,searchBar);searchBar.click();searchBar.sendKeys(getNameByAvrg());waitToBeClickable(driver,buttonDeleteCustomer);buttonDeleteCustomer.click();searchBar.clear();
        return this;
    }

    /**
     * Функция возвращающая имя пользователя близкого к средней длине имен
     */
    public String getNameByAvrg(){
        // Получение списка имент клиентов
        List<WebElement> customers = driver.findElements(By.xpath("//table//tr"));
        // Вычисление средней длины имен
        double avrgLength = customers.stream().skip(1) //Пропуск заголовка таблицы
                .map(user -> user.findElement(By.xpath("./td[1]")).getText().length()).mapToDouble(Integer::doubleValue).average().orElse(0);
        String closestUserName = customers.stream().skip(1) //Пропуск заголовка таблицы
                .min(Comparator.comparing(user -> Math.abs(user.findElement(By.xpath("./td[1]")).getText().length() - avrgLength))) //Поиск клиента
                .map(user -> user.findElement(By.xpath("./td[1]")).getText()) //Запись имени клиента
                .orElse(null);
        return closestUserName; // Возращение имени клиента в формате String
    }

}
