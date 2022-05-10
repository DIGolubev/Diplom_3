package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import praktikm.pages.*;
//import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//import static com.codeborne.selenide.WebDriverRunner.setWebDriver
import static org.junit.Assert.assertTrue;

public class LoginTest {
    /**
     * Вход
     * Проверь:
     * - вход по кнопке «Войти в аккаунт» на главной,
     * - вход через кнопку «Личный кабинет»,
     * - вход через кнопку в форме регистрации,
     * - вход через кнопку в форме восстановления пароля.
     */

    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);

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
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithAccountButton() {
        mainPage.clickEnterAccountButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();

        assertTrue("Не произошел переход на главную станицу", mainPage.inMainPageWithLogin());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginWithPersonalAccountButton() {
        mainPage.clickPersonalAccountButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();

        assertTrue("Не произошел переход на главную станицу", mainPage.inMainPageWithLogin());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginWithRegistrationForm() {
        mainPage.clickEnterAccountButton();
        loginPage.clickLoginButton();
        registrationPage.clickEnterButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();

        assertTrue("Не произошел переход на главную станицу", mainPage.inMainPageWithLogin());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    public void loginWithPasswordRecovery() {
        mainPage.clickEnterAccountButton();
        loginPage.clickPasswordRecoveryButton();
        passwordRecoveryPage.clickEnterButton();
        loginPage.fillEmailInput(email)
                .fillPasswordInput(password)
                .clickEnterButton();

        assertTrue("Не произошел переход на главную станицу", mainPage.inMainPageWithLogin());
    }
}
