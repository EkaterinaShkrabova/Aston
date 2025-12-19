import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    public void openPage() {
        driver.get("https://www.mts.by");

        try {
            WebElement acceptCookiesButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Принять')]")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка принятия куки не найдена: " + e.getMessage());
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.pay")));
    }

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "E:\\ProgramFiles\\Загрузки\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement titleElement = driver.findElement(By.cssSelector("section.pay h2"));
        String titleText = titleElement.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", titleText, "Заголовок блока не соответствует ожидаемому");
    }

    @Test
    public void testPaymentLogosPresence() {
        List<WebElement> logos = driver.findElements(By.cssSelector("section.pay .pay__partners img"));
        assertEquals(5, logos.size(), "Количество логотипов не соответствует ожидаемому");

        List<String> expectedAlts = Arrays.asList("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        for (String expectedAlt : expectedAlts) {
            boolean found = logos.stream().anyMatch(img -> expectedAlt.equals(img.getAttribute("alt")));
            assertTrue(found, "Логотип с alt='" + expectedAlt + "' не найден");
        }
    }

    @Test
    public void testServiceLink() {
        WebElement serviceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertNotNull(serviceLink, "Ссылка 'Подробнее о сервисе' не найдена");

        serviceLink.click();
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Переход по ссылке 'Подробнее о сервисе' не произошёл");
    }

    @Test
    public void testPaymentFormSubmission() {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        WebElement submitButton = driver.findElement(By.cssSelector("#pay-connection button[type='submit']"));

        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        sumInput.clear();
        sumInput.sendKeys("10");

        emailInput.clear();
        emailInput.sendKeys("test@example.com");

        submitButton.click();
        //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-message")));
//         WebElement successMessage = driver.findElement(By.cssSelector(".success-message"));
//         assertTrue(successMessage.isDisplayed(), "Сообщение об успешном проведении платежа не отображается");

    }
}