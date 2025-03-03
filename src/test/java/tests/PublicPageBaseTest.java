package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.PublicPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public abstract class PublicPageBaseTest {

    PublicPage publicPage = new PublicPage();

    protected String fio = "Соминский Антон Константинович";
    protected String email = "sominskyanton@yandex.ru";
    protected String phone = "89056568475";
    protected String confirmationCode = "1111";

    @BeforeEach
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;

        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Selenide.open("https://www.rmteam.ru/routing/public");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
