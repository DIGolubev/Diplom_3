package Praktikum.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage {
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement enterButton;

    public PasswordRecoveryPage clickEnterButton() {
        enterButton.click();
        return this;
    }
}
