package praktikm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //Поиск кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    //Поиск кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    //Поиск кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = "//button[text() = 'Оформить заказ']")
    private SelenideElement createOrderButton;

    //Поиск кнопки Начинки
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement fillingButton;

    //Поиск кнопки Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    //Поиск кнопки Начинки
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement saucesButton;

    //Поиск текста Начинки
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingText;

    //Поиск текста Булки
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunsText;

    //Поиск текста "соусы"
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement saucesText;

    /**
     * Клик по кнопке для входа в личный кабинет
     */
    public MainPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return this;
    }

    /**
     * Клик по кнопке для входа в аккаунт
     */
    public MainPage clickEnterAccountButton() {
        enterAccountButton.click();
        return this;
    }

    /**
     * Кнопка создания заказа есть на станице
     */
    public boolean inMainPageWithLogin() {
        createOrderButton.shouldBe(Condition.visible);
        return true;
    }

    /**
     * Кнопка входа в аккаунт есть на странице
     */
    public boolean inMainPageWithoutLogin() {
        enterAccountButton.shouldBe(Condition.visible);
        return true;
    }

    /**
     * Клик по кнопке Соусы
     */
    public MainPage clickSauces() {
        saucesButton.click();
        return this;
    }

    /**
     * Клик по кнопке Начинки
     */
    public MainPage clickFilling() {
        fillingButton.click();
        return this;
    }

    /**
     * Клик по кнопке Булочки
     */
    public MainPage clickBuns() {
        bunsButton.click();
        return this;
    }

    /**
     * Надпись Соусы видна
     */
    public boolean isSaucesText() {
        saucesText.shouldHave(exactText("Соусы"));
        return true;
    }

    /**
     * Надпись Начинки видна
     */
    public boolean isFillingText() {
        fillingText.shouldHave(exactText("Начинки"));
        return true;
    }

    /**
     * Надпись Булки видна
     */
    public boolean isBunsText() {
        bunsText.shouldHave(exactText("Булки"));
        return true;
    }
}
