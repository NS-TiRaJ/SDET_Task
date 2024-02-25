package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static helpers.Waiters.waitToBeClickable;

/**
 * Клас с локаторами и шагами заголовка менеджера
 */
public class MainManagerHeader {

    private final WebDriver driver;
    /**
     * Конструктор WebDriver для работы с элементами страницы
     */
    public MainManagerHeader(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Блок с локаторами элементов
     */
    //Локатор кнопки открытия меню Add Customers
    @FindBy (xpath = "//button[@ng-click='addCust()']")
    private WebElement formToAddCustomer;

    //Локатор и переменная кнопки открытия меню Open Account
    @FindBy (xpath = "//button[ng-click='openAccount()']")
    private WebElement accountSettings;

    // Локатор и переменная открытия таблицы Customers
    @FindBy (xpath = "//button[@ng-click='showCust()']")
    private WebElement customersTable;

    /**
     * Блок с шагами теста
     */
    @Step ("Открытие формы добавления нового клиента")
    public MainManagerHeader openFormToAddCustomer(){
        waitToBeClickable(driver,formToAddCustomer);formToAddCustomer.click();
        return this;
    }
    @Step ("Открытие настроек аккаунта клиента")
    public MainManagerHeader openAccountSettings(){
        waitToBeClickable(driver,accountSettings);accountSettings.click();
        return this;
    }
    @Step ("Открытие таблицы Customers")
    public MainManagerHeader openCustomersTable(){
        waitToBeClickable(driver,customersTable);customersTable.click();
        return this;
    }
}
