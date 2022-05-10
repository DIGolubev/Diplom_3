package praktikum;

import praktikm.pages.LoginPage;
import praktikm.pages.MainPage;
import praktikm.pages.PersonalAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class DesignerTest {
    /**
     * Проверь, что работают переходы к разделам:
     * - «Булки»,
     * - «Соусы»,
     * - «Начинки».
     */

    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
    private final String email = "sdsdss@mail.ru";
    private final String password = "sdsdsd121212";

    @Before
    public void setUp() {
        /*
         * Для тестов в Яндекс браузере + откомментировать импорт библиотек
         * System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
         * ChromeDriver driver = new ChromeDriver();
         * setWebDriver(driver);
         */
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @After
    public void tearDown() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Переключение на выбор начинок")
    public void fillingChoose() {
        mainPage.clickPersonalAccountButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();
        mainPage.clickFilling();

        assertTrue("Не произошло переключение на выбор начинок", mainPage.isFillingText());
    }

    @Test
    @Description("Переключение на выбор соусов")
    public void saucesChoose() {
        mainPage.clickEnterAccountButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();
        mainPage.clickSauces();

        assertTrue("Не произошло переключение на выбор соусов", mainPage.isSaucesText());
    }

    @Test
    @Description("Переключение на выбор булок")
    public void bunsChoose() {
        mainPage.clickEnterAccountButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();
        mainPage.clickFilling();
        mainPage.clickBuns();

        assertTrue("Не произошло переключение на выбор булок", mainPage.isBunsText());
    }
}
