package Praktikum;

import Praktikum.Pages.MainPage;
import Praktikum.Pages.PersonalAccountPage;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import static com.codeborne.selenide.WebDriverRunner.setWebDriver
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {
    /**
     * Проверь переходы по клику:
     * - на «Конструктор»
     * - на логотип Stellar Burgers.
     */
    MainPage mainPage;
    PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);

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
        getWebDriver().quit();
    }

    @Test
    @Description("Клик на «Конструктор» возвращает на главную страницу")
    public void goToMainPageWithClickDesigner() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickDesignerText();

        assertTrue("Не произошел переход на главную станицу", mainPage.inMainPageWithoutLogin());
    }

    @Test
    public void goToMainPageWithClickStellarBurgers() {
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickDesignerIcon();

        assertTrue("Не произошел переход на главную станицу", mainPage.inMainPageWithoutLogin());
    }
}
