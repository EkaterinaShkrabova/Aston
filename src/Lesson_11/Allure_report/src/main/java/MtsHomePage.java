import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By acceptCookiesButton =
            By.xpath("//button[contains(text(),'Принять')]");

    private By paySection =
            By.cssSelector("section.pay");

    private By blockTitle =
            By.cssSelector("section.pay h2");

    private By paymentLogos =
            By.cssSelector(".pay__partners img");

    private By serviceLink =
            By.linkText("Подробнее о сервисе");

    public By connectionPhone = By.id("connection-phone");
    public By connectionSum = By.id("connection-sum");
    public By connectionEmail = By.id("connection-email");
    private By connectionSubmit =
            By.cssSelector("#pay-connection button[type='submit']");

    public By internetPhone = By.id("internet-phone");
    public By internetSum = By.id("internet-sum");
    public By internetEmail = By.id("internet-email");

    public By instalmentScore = By.id("score-instalment");
    public By instalmentSum = By.id("instalment-sum");
    public By instalmentEmail = By.id("instalment-email");

    public By arrearsScore = By.id("score-arrears");
    public By arrearsSum = By.id("arrears-sum");
    public By arrearsEmail = By.id("arrears-email");

    public void open() {
        driver.get("https://www.mts.by");
    }

    public void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        } catch (Exception e) {
            System.out.println("Cookies не появились");
        }
    }

    public void waitForPaySection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paySection));
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText().replace("\n", " ").trim();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickServiceLink() {
        driver.findElement(serviceLink).click();
    }

    public String getPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public void fillConnectionForm(String phone, String sum, String email) {
        driver.findElement(connectionPhone).sendKeys(phone);
        driver.findElement(connectionSum).sendKeys(sum);
        driver.findElement(connectionEmail).sendKeys(email);
    }

    public void submitConnectionForm() {
        driver.findElement(connectionSubmit).click();
    }
}