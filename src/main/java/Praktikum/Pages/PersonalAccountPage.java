package Praktikum.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    @FindBy(how = How.XPATH, using = "//*[text()='Выход']")
    private SelenideElement exitButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement designerText;

    @FindBy(how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement designerIcon;

    public PersonalAccountPage clickExitButton() {
        exitButton.click();
        return this;
    }

    public PersonalAccountPage clickDesignerText() {
        designerText.click();
        return this;
    }

    public PersonalAccountPage clickDesignerIcon() {
        designerIcon.click();
        return this;
    }
}
