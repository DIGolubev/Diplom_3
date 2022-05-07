package Praktikum.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage {

    //Поиск кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement enterButton;

    /**
     * Клик по кнопке войти в аккаунт
     */
    public PasswordRecoveryPage clickEnterButton() {
        enterButton.click();
        return this;
    }
}
