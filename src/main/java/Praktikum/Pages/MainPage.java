package Praktikum.Pages;

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

    @FindBy(how = How.XPATH, using = "//*[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement createOrderButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement fillingButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingText;

    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunsText;

    //Надпись "соусы"
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
     * Клик
     */
    public MainPage clickEnterAccountButton() {
        enterAccountButton.click();
        return this;
    }

    public boolean inMainPageWithLogin() {
        createOrderButton.shouldBe(Condition.visible);
        return true;
    }

    public boolean inMainPageWithoutLogin() {
        enterAccountButton.shouldBe(Condition.visible);
        return true;
    }

    public MainPage clickSauces() {
        saucesButton.click();
        return this;
    }

    public MainPage clickFilling() {
        fillingButton.click();
        return this;
    }

    public MainPage clickBuns() {
        bunsButton.click();
        return this;
    }

    public boolean isSaucesText() {
        saucesText.shouldHave(exactText("Соусы"));
        return true;
    }

    public boolean isFillingText() {
        fillingText.shouldHave(exactText("Начинки"));
        return true;
    }

    public boolean isBunsText() {
        bunsText.shouldHave(exactText("Булки"));
        return true;
    }
}
