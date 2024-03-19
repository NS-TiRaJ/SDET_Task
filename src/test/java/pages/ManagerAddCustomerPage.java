package pages;

import helpers.GenerateRandomData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waiters.waitToBeClickable;

/**
 * Клас с локаторами и шагами страницы добавления клиента
 */
public class ManagerAddCustomerPage {

    private final WebDriver driver;

    /**
     * Конструктор WebDriver для работы с элементами страницы
     */
    public ManagerAddCustomerPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Блок с локаторами элементов
     */
    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement inputPostCode;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonAddCustomer;

    /**
     * Блок с шагами теста
     */
    private static final String postCode = GenerateRandomData.getRandomPostCode();// Генерация рандомного значения для PostCode

    @Step("Заполнение поля First Name")
    public ManagerAddCustomerPage fillFirstNameField() {
        waitToBeClickable(driver, inputFirstName);
        inputFirstName.click();
        inputFirstName.sendKeys(GenerateRandomData.getNameByPostCode(postCode));
        return this;

    }

    @Step("Заполнение поля Last Name")
    public ManagerAddCustomerPage fillLastNameField() {
        waitToBeClickable(driver, inputLastName);
        inputLastName.click();
        inputLastName.sendKeys(GenerateRandomData.getRandomLastName());
        return this;
    }

    @Step("Заполнение поля Post Code")
    public ManagerAddCustomerPage fillPostCodeField() {
        waitToBeClickable(driver, inputPostCode);
        inputPostCode.click();
        inputPostCode.sendKeys(postCode);
        return this;
    }

    @Step("Нажатие кнопки Add Customer")
    public ManagerAddCustomerPage pressAddCustomerButton() {
        waitToBeClickable(driver, buttonAddCustomer);
        buttonAddCustomer.click();
        return this;
    }
}
