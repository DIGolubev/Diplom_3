package praktikum;

import praktikm.pages.LoginPage;
import praktikm.pages.MainPage;
import praktikm.pages.RegistrationPage;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.chrome.ChromeDriver;

import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
//import static com.codeborne.selenide.WebDriverRunner.setWebDriver

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    /**
     * Регистрация
     * Проверь:
     * - Успешную регистрацию.
     * - Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
     */

    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);

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

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistration() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickLoginButton();
        registrationPage.fillNameInput("Имя")
                .fillEmailInput("test@mail.ru")
                .fillPasswordInput("123456");

        assertTrue("Не произошел переход на станицу авторизации", loginPage.inLoginPage());
    }

    @Test
    public void wrongRegistration() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickLoginButton();
        registrationPage.fillNameInput("Имя")
                .fillEmailInput("test@mail.ru")
                .fillPasswordInput("12345")
                .registrationButtonClick();

        assertTrue("Ошибки некорректного пароля нет", registrationPage.passwordTextErrorVisible());
    }
}
