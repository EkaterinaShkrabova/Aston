import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Allure;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsPaymentTests {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private MtsHomePage mtsHomePage;

    private By iframe = By.xpath("//body/div[9]/div/iframe");
    private By amountText = By.cssSelector(".pay-description__cost");
    private By payButton = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button/span");
    private By phoneText = By.cssSelector(".pay-description__text");

    private By cardNumber = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    private By cardExpiry = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    private By cardCvc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label");

    private By visaIcon = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]");
    private By masterIcon = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]");

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @BeforeEach
    void openPage() {
        mtsHomePage = new MtsHomePage(driver);
        mtsHomePage.open();
        mtsHomePage.acceptCookiesIfPresent();
        mtsHomePage.waitForPaySection();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    @Description("Проверка заголовка блока 'Онлайн пополнение без комиссии'")
    void testBlockTitle() {
        assertEquals(
                "Онлайн пополнение без комиссии",
                mtsHomePage.getBlockTitle()
        );
    }

    @Test
    @Order(2)
    @Description("Проверка наличия логотипов способов оплаты")
    void testPaymentLogos() {
        List<WebElement> logos = mtsHomePage.getPaymentLogos();
        assertEquals(5, logos.size());

        List<String> expected = Arrays.asList(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        for (String alt : expected) {
            assertTrue(
                    logos.stream().anyMatch(l -> alt.equals(l.getAttribute("alt"))),
                    "Не найден логотип: " + alt
            );
        }
    }

    @Test
    @Order(3)
    @Description("Проверка отображения плейсхолдеров")
    void testPlaceholdersForAllForms() {

        assertEquals("Номер телефона",
                mtsHomePage.getPlaceholder(mtsHomePage.connectionPhone));
        assertEquals("Сумма",
                mtsHomePage.getPlaceholder(mtsHomePage.connectionSum));
        assertEquals("E-mail для отправки чека",
                mtsHomePage.getPlaceholder(mtsHomePage.connectionEmail));
        assertEquals("Номер абонента",
                mtsHomePage.getPlaceholder(mtsHomePage.internetPhone));
        assertEquals("Сумма",
                mtsHomePage.getPlaceholder(mtsHomePage.internetSum));
        assertEquals("E-mail для отправки чека",
                mtsHomePage.getPlaceholder(mtsHomePage.internetEmail));
        assertEquals("Номер счета на 44",
                mtsHomePage.getPlaceholder(mtsHomePage.instalmentScore));
        assertEquals("Сумма",
                mtsHomePage.getPlaceholder(mtsHomePage.instalmentSum));
        assertEquals("E-mail для отправки чека",
                mtsHomePage.getPlaceholder(mtsHomePage.instalmentEmail));
        assertEquals("Номер счета на 2073",
                mtsHomePage.getPlaceholder(mtsHomePage.arrearsScore));
        assertEquals("Сумма",
                mtsHomePage.getPlaceholder(mtsHomePage.arrearsSum));
        assertEquals("E-mail для отправки чека",
                mtsHomePage.getPlaceholder(mtsHomePage.arrearsEmail));
    }

    @Test
    @Order(4)
    @Description("Проверка отображения окна оплаты и его элементов")
    void testConnectionPaymentWindow() {

        mtsHomePage.fillConnectionForm("297777777", "10", "test@test.by");
        mtsHomePage.submitConnectionForm();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountText));
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneText));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvc));
        wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon));
        wait.until(ExpectedConditions.visibilityOfElementLocated(masterIcon));

        assertTrue(driver.findElement(amountText).getText().contains("10"));
        assertTrue(driver.findElement(phoneText).getText().contains("297777777"));

        assertTrue(driver.findElement(cardNumber).getText().contains("Номер карты"));
        assertTrue(driver.findElement(cardExpiry).getText().contains("Срок действия"));
        assertTrue(driver.findElement(cardCvc).getText().contains("CVC"));

        assertTrue(driver.findElement(visaIcon).isDisplayed());
        assertTrue(driver.findElement(masterIcon).isDisplayed());

        assertTrue(driver.findElement(payButton).getText().contains("Оплатить 10.00 BYN"));

        driver.switchTo().defaultContent();
    }
}