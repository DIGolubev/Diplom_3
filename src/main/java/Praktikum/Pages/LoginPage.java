package Praktikum.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //Поиск кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement loginButton;

    //Поиск кнопки Восстановить пароль
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement passwordRecoveryButton;

    //Поиск кнопки Войти
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement enterButton;

    //Поиск текстового ввода для email
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) input")
    private SelenideElement emailInput;

    //Поиск текстового ввода для пароля
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) input")
    private SelenideElement passwordInput;

    /**
     * Клик по кнопке для регистрации
     */
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    /**
     * Видна ли кнопка Войти на странице для логина
     */
    public boolean inLoginPage() {
        enterButton.shouldBe(Condition.visible);
        return true;
    }

    /**
     * Принимает EMAIL и вводит в поле
     */
    public LoginPage fillEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    /**
     * Принимает ПАРОЛЬ и вводит в поле
     */
    public LoginPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    /**
     * Клик по кнопке Войти
     */
    public LoginPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    /**
     * Клик по кнопке восстановить пароль
     */
    public LoginPage clickPasswordRecoveryButton() {
        passwordRecoveryButton.click();
        return this;
    }
}
