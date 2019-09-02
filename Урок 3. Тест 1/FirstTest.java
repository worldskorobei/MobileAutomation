import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;


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
        driver.rotate(ScreenOrientation.PORTRAIT);

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

//    @Test
//    public void testCompare_item_title() {
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
//                "Cannot find search input", 5);
//
//        WebElement title_element_item_title1 = waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java']"),
//                "Cannot fiend item title 1",
//                15);
//
//        String article_title_item_title1 = title_element_item_title1.getAttribute("text");
//        Assert.assertEquals("We see unexpected title!",
//                "Java",
//                article_title_item_title1);
//// Вообще эта проверка на текст не нужна, так как я уже ищу по нужному элементу текста. правильно ли я понимаю?
//
//        WebElement title_element_item_title2 = waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
//                "Cannot fiend item title 2", 15);
//
//        String article_title_item_title2 = title_element_item_title2.getAttribute("text");
//
//        Assert.assertEquals("We see unexpected title!",
//                "JavaScript",
//                article_title_item_title2);
//
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X to cancel search", 5);
//
//        waitForElementNotPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']//*[@text='Java']"),
//                "Cannot fiend item title 1", 15);
//
//        waitForElementNotPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']//*[@text='JavaScript']"),
//                "Cannot fiend item title 2", 15);
//
//    }
//
//
//
//    @Test
//    public void testCompare_item_title_name() {
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
//                "Cannot find search input", 5);
//
//        WebElement title_element_title_name1 = waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java']"),
//                "Cannot fiend item title 1",
//                15);
//
//        String article_title_title_name1 = title_element_title_name1.getAttribute("text");
//        Assert.assertEquals("We see unexpected title!",
//                "Java",
//                article_title_title_name1);
//
//        WebElement title_element_title_name2 = waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
//                "Cannot fiend item title 2", 15);
//
//        String article_title_title_name2 = title_element_title_name2.getAttribute("text");
//
//        Assert.assertEquals("We see unexpected title!",
//                article_title_title_name2.contains("Java"),
//                true);
//
//        WebElement title_element_title_name3 = waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
//                "Cannot fiend item title 3", 15);
//
//        String article_title_title_name3 = title_element_title_name3.getAttribute("text");
//
//        Assert.assertEquals("We see unexpected title!",
//                article_title_title_name3.contains("Java"),
//                true);
//
//        WebElement title_element_title_name4 = waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java version history']"),
//                "Cannot fiend item title 3", 15);
//
//        String article_title_title_name4 = title_element_title_name4.getAttribute("text");
//
//        Assert.assertEquals("We see unexpected title!",
//                article_title_title_name4.contains("Java"),
//                true);
//
//    }
//
//    @Test
//    public void testSwipeArticle() {
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Appium",
//                "Cannot find search input", 5);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
//                "Cannot fiend 'org.wikipedia:id/page_list_item_container'", 5);
//
//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot fiend article title", 15);
//
//       swipeUpToFindElement(By.xpath("//*[@text='View page in browser']"), "Cannot find the and of the article", 20);
//    }

//    @Test
//    public void saveFirstArticleToMyList() {
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
//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot fiend article title", 15);
//        waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "Cannot find button to open article options", 5);
//
//        waitForElementAndClick(By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find option to add article to reading list",
//                5);
//        waitForElementAndClick(By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find 'Got it' tip overlay",
//                5);
//        waitForElementAndClear(By.id("org.wikipedia:id/text_input"),
//                "Cannot find input to set name of articles folder", 5);
//
//        String name_of_folder = "Learning programming";
//        waitForElementAndSendKeys(By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "Cannot find intup to set name of articles folder", 5);
//
//        waitForElementAndClick(By.xpath("//*[@text='OK']"),
//                "Cannot pres ok button",
//                5);
//
//        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find X link",
//                5);
//
//        waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to My List", 8);
//
//        waitForElementAndClick(By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find created folder",
//                5);
//        swipeElementToLeft(By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot delete saved article");
//
//    }

//    @Test
//    public void testAmountOfNotEmptySearch() {
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        String search_line = "Linkin Park Diskography";
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), search_line,
//                "Cannot find search input", 5);
//
//        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
//        waitForElementPresent(By.xpath(search_result_locator), "Cannot find anything by the request " + search_line, 15);
//
//        int amount_of_search_results = getAmountOfElements(By.xpath(search_result_locator));
//
//        Assert.assertTrue("We found too few results!", amount_of_search_results > 0);
//
//    }

//    @Test
//    public void testAmountOfEmptySearch() {
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        String search_line = "affafasfassdddd";
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), search_line,
//                "Cannot find search input", 5);
//
//        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
//        String empty_result_label = "//*[@text='No results found']";
//
//        waitForElementPresent(By.xpath(empty_result_label), "Cannot find emty result label by the request " + search_line, 15 );
//
//
//        assertElementNotPresent(By.xpath(search_result_locator),"we've found some results by request " + search_line );
//    }
//
//
//    @Test
//    public void testChangeScreenOrientationOnSearchResults() {
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        String search_line = "Java";
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), search_line,
//                "Cannot find search input", 5);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot fiend 'Object-oriented programming language'" + search_line, 15);
//
//        String tittle_before_rotation = waitForElementAntGetAttribute(By.id("org.wikipedia:id/view_page_title_text"), "text", "Cannot find title of article", 15);
//
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//
//        String tittle_after_rotation = waitForElementAntGetAttribute(By.id("org.wikipedia:id/view_page_title_text"), "text", "Cannot find title of article", 15);
//
//        Assert.assertEquals("Article title have been changed after screen rotation", tittle_before_rotation, tittle_after_rotation);
//
//        driver.rotate(ScreenOrientation.PORTRAIT);
//
//        String tittle_after_second_rotation = waitForElementAntGetAttribute(By.id("org.wikipedia:id/view_page_title_text"), "text", "Cannot find title of article", 15);
//
//        Assert.assertEquals("Article title have been changed after screen rotation", tittle_before_rotation, tittle_after_second_rotation);
//
//    }
//    @Test
//    public void testCheckSearchArticleInBackground(){
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia'", 5);
//
//        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
//                "Cannot find search input", 5);
//
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot fiend 'org.wikipedia:id/page_list_item_container'", 5);
//
//        driver.runAppInBackground(2);
//
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot fiend article after returning from background", 5);
//
//    }

    @Test
    public void saveTwoArticleToMyList() {

        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'", 5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Java",
                "Cannot find search input", 5);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot fiend 'org.wikipedia:id/page_list_item_container'", 5);

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot fiend article title", 15);
        waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "Cannot find button to open article options", 5);

        waitForElementAndClick(By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5);
        waitForElementAndClick(By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5);
        waitForElementAndClear(By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder", 5);

        String name_of_folder = "Learning programming";
        waitForElementAndSendKeys(By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot find input to set name of articles folder", 5);

        waitForElementAndClick(By.xpath("//*[@text='OK']"),
                "Cannot pres ok button",
                5);

        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5);
// вторая статья
        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia'", 5);

        waitForElementAndSendKeys(By.xpath("//*[contains(@text, 'Search…')]"), "Android",
                "Cannot find search input", 5);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Wikimedia disambiguation page']"),
                "Cannot fiend 'org.wikipedia:id/page_list_item_container'", 5);

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot fiend article title", 15);
        waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"), "Cannot find button to open article options", 10);

        waitForElementAndClick(By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5);
        waitForElementAndClick(By.id("org.wikipedia:id/list_of_lists"),
                "Cannot find list tip overlay",
                5);


        waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5);

        // переход в список и удаление

        waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My List", 8);

        waitForElementAndClick(By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find created folder",
                5);
        swipeElementToLeft(By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article");


        //проверка на наличие

        String result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Android']";
        waitForElementPresent(By.xpath(result_locator), "Cannot find anything by the request ", 10);


        int amount_of_list = getAmountOfElements(By.xpath(result_locator));
        Assert.assertTrue("We found too few results!", amount_of_list == 1);

        //переход

        waitForElementAndClick(By.xpath(result_locator), "not fiend element for click", 5);
        // проверка тайтла
        waitForElementPresent(By.xpath("//*[@text='Android']"), "its not Android page", 5);


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

    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    protected void swipeUpQuick() {
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipe) {
        int already_swiped = 0;


        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipe) {
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }

    }

    protected void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(by, error_message, 10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y).waitAction(1000).moveTo(left_x, middle_y).release().perform();

    }

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + " supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAntGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
}
