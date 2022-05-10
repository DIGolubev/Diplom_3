package praktikm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    //Поиск поля для ввода Имени
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) input")
    private SelenideElement nameInput;

    //Поиск поля для ввода email
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) input")
    private SelenideElement emailInput;

    //Поиск поля для ввода пароля
    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) input")
    private SelenideElement passwordInput;

    //Поиск кнопки войти
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement enterButton;

    //Текст ошибки при некрректном вводе пароля
    @FindBy(how = How.XPATH, using = "//*[text()='Некорректный пароль']")
    private SelenideElement passwordTextError;

    //Поиск кнопки регистрации
    @FindBy(how = How.XPATH, using = "//*[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    /**
     * Принимает ИМЯ и вводит в поле
     */
    public RegistrationPage fillNameInput(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    /**
     * Принимает EMAIL и вводит в поле
     */
    public RegistrationPage fillEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    /**
     * Принимает ПАРОЛЬ и вводит в поле
     */
    public RegistrationPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    /**
     * Клик по кнопке регистрации
     */
    public RegistrationPage registrationButtonClick() {
        registrationButton.click();
        return this;
    }

    /**
     * Клик по кнопке Войти
     */
    public RegistrationPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    /**
     * Ошибка при вводе пароля
     */
    public boolean passwordTextErrorVisible() {
        passwordTextError.shouldBe(Condition.visible);
        return true;
    }
}
