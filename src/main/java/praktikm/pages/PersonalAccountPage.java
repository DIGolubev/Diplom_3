package praktikm.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    //Поиск кнопки выхода из аккаунта
    @FindBy(how = How.XPATH, using = "//*[text()='Выход']")
    private SelenideElement exitButton;

    //Поиск надписи Конструктор
    @FindBy(how = How.XPATH, using = "//*[text()='Конструктор']")
    private SelenideElement designerText;

    //Поиск логотипо Конструктор
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement designerIcon;

    /**
     * Клик по кнопке Выход
     */
    public PersonalAccountPage clickExitButton() {
        exitButton.click();
        return this;
    }

    /**
     * Клик по надписи Конструктор
     */
    public PersonalAccountPage clickDesignerText() {
        designerText.click();
        return this;
    }

    /**
     * Клик по логотипу конструктор
     */
    public PersonalAccountPage clickDesignerIcon() {
        designerIcon.click();
        return this;
    }
}
