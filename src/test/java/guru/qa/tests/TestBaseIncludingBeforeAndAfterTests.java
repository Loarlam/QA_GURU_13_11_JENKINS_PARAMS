package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.attachments.AttachmentsForReport;
import guru.qa.config.CredentialsConfig;
import guru.qa.pages.PageOfRegistrationForm;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBaseIncludingBeforeAndAfterTests {
    PageOfRegistrationForm pageOfRegistrationForm = new PageOfRegistrationForm();
    DataForTheTest dataForTheTest = new DataForTheTest();
    static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAllTests() {
        SelenideLogger.addListener("Allure", new AllureSelenide());

        String remoteLink = System.getProperty("remoteLink");
        Configuration.remote = "https://" + credentialsConfig.login() + ":" + credentialsConfig.password() + "@" + remoteLink;

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "100");
        Configuration.browserSize = System.getProperty("resolution", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterAll
    static void afterAllTests() {
        AttachmentsForReport.attachScreenshot();
        AttachmentsForReport.pageSource();
        AttachmentsForReport.browserConsoleLogs();
        AttachmentsForReport.addVideo();
    }
}