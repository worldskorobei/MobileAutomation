import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;


public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/Admin/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("Http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //    @Test
//    public void testCancelSearch() {
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
//                "Cannot find search input", 5);
//
//        waitForElementAndClear(By.id("org.wikipedia:id/search_src_text"),
//                "Cannot fiend search field", 5);
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X to cancel search", 5);
//
//        waitForElementNotPresent(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "X is still present on the page", 5);
//
//    }
//
//
//
//    @Test
//    public void firstTest() {
//        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Cannot find Search Wikipedia", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java", "Cannot find search input", 5);
//
//        waitForElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"), "Cannot find 'Object-oriented programming language' topic searching by 'Java'", 15);
//    }
//
//
//    @Test
//    public void testCompareArticleTitle() {
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
//                "Cannot find search input", 5);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot fiend 'org.wikipedia:id/page_list_item_container'", 5);
//
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot fiend article title", 15);
//
//        String article_title = title_element.getAttribute("text");
//
//        Assert.assertEquals("We see unexpected title!",
//                "Java (programming language)",
//                article_title);
//    }
//
//
//    @Test
//    public void testCompareArticleTitleSearch() {
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        WebElement title_element_search = waitForElementPresent(By.xpath("//*[contains(@text, 'Search…')]"),
//                "Cannot find search input", 15);
//
//        String article_title_search = title_element_search.getAttribute("text");
//
//        Assert.assertEquals("We see unexpected title!",
//                "Search…",
//                article_title_search);
//
//    }

    @Test
    public void testCompare_item_title() {

        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'", 5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
                "Cannot find search input", 5);

        WebElement title_element_item_title1 = waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java']"),
                "Cannot fiend item title 1",
                15);

        String article_title_item_title1 = title_element_item_title1.getAttribute("text");
        Assert.assertEquals("We see unexpected title!",
                "Java",
                article_title_item_title1);
// Вообще эта проверка на текст не нужна, так как я уже ищу по нужному элементу текста. правильно ли я понимаю?

        WebElement title_element_item_title2 = waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
                "Cannot fiend item title 2", 15);

        String article_title_item_title2 = title_element_item_title2.getAttribute("text");

        Assert.assertEquals("We see unexpected title!",
                "JavaScript",
                article_title_item_title2);


        waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search", 5);

        waitForElementNotPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']//*[@text='Java']"),
                "Cannot fiend item title 1", 15);

        waitForElementNotPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']//*[@text='JavaScript']"),
                "Cannot fiend item title 2", 15);

    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
}
