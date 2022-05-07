package Praktikum.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) input")
    private SelenideElement nameInput;
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) input")
    private SelenideElement emailInput;
    @FindBy(how = How.CSS, using = "fieldset:nth-child(3) input")
    private SelenideElement passwordInput;
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement enterButton;

    //Текст ошибки при некрректном вводе пароля
    @FindBy(how = How.XPATH, using = "//*[text()='Некорректный пароль']")
    private SelenideElement passwordTextError;

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

    public RegistrationPage registrationButtonClick() {
        registrationButton.click();
        return this;
    }

    public RegistrationPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    /**
     * @return
     */
    public boolean passwordTextErrorVisible() {
        passwordTextError.shouldBe(Condition.visible);
        return true;
    }
}
