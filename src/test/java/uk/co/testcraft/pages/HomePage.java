package uk.co.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.Thread.sleep;

public class HomePage extends AbstractPage {

    private static final String URL = "https://www.phptravels.net/";

    @FindBy(css = "#collapse [class='lightcaret mt-2 go-left']")
    private WebElement myAccountButton;

    @FindBy(css = "#collapse #li_myaccount li:nth-of-type(2) .go-text-right")
    private WebElement signUpButton;

    @FindBy(css = "[method] .form-group:nth-of-type(3) .form-control")
    private WebElement firstName;

    @FindBy(css = "[method] .form-group:nth-of-type(4) .form-control")
    private WebElement lastName;

    @FindBy(css = "[method] .form-group:nth-of-type(5) .form-control[method] .form-group:nth-of-type(3) .form-control")
    private WebElement mobileNumber;

    @FindBy(css = "[method] .form-group:nth-of-type(6) .form-control")
    private WebElement email;

    @FindBy(css = "[method] .form-group:nth-of-type(7) .form-control")
    private WebElement password1;

    @FindBy (css ="[method] .form-group:nth-of-type(8) .form-control")
    private WebElement password2;

    @FindBy (css= "[method] button")
    private WebElement submitForm;

    @FindBy (css= "#collapse #li_myaccount li:nth-of-type(1) .go-text-right")
    private WebElement logInButton;

    @FindBy (css= "[class='wpb_column vc_column_container vc_col-sm-6']:nth-of-type(1) .btn-block")
    private WebElement bookNowButton;

    @FindBy(css= "[class='col-md-4 col-xs-12 go-text-right go-right form-group bgwhite h50'] .select2-chosen")
    private WebElement search;

    @FindBy(css= "[href='\\#flights']")
    private WebElement flightsButton;

    @FindBy(xpath= "//div[@id='s2id_location_from']/a[@href='javascript:void(0)']")
    private WebElement from;

    @FindBy(xpath= "//div[@id='s2id_location_to']//span[@class='select2-chosen']")
    private WebElement to;

    @FindBy(css= "[role='tabpanel']:nth-of-type(4) form > div:nth-of-type(3) [type]")
    private WebElement departDate;

    @FindBy(name= "totalManualPassenger")
    private WebElement passengers;

    @FindBy(css = "body .dropdown-menu:nth-child(18) .datepicker-days .next")
    private WebElement nextMonthButton;

    @FindBy(name = "madult")
    private WebElement adultDropdown;

    @FindBy(name = "mchildren")
    private WebElement childDropdown;

    @FindBy(name = "minfant")
    private WebElement infantDropdown;

    @FindBy(css= "[class='bgfade col-md-1 col-xs-12 search-button'] [type]")
    private WebElement flightSearch;

    @FindBy(css ="body .dropdown-menu:nth-child(18) tr:nth-of-type(2) .day:nth-of-type(6)")
    private WebElement testDate;

    @FindBy(name = "cabinclass")
    private WebElement classDropdown;

    @FindBy (css = "[class='bgfade col-md-1 col-xs-12 search-button'] [type]")
    private WebElement flightsSearch;

    @FindBy(css= "#body-section > div.featured-back > div > div > div.hotels.owl-carousel.owl-theme > div > div > div:nth-child(1) > div > div.imgLodBg > img")
    private WebElement hotelPicture;

    @FindBy(css= ".owl-wrapper > .owl-item:nth-of-type(1) .loader")
    private WebElement bookHotelNow;

    @FindBy (xpath = "//input[@placeholder='0']")
    private WebElement TESTPASSENGERS;

    @FindBy (css =".owl-wrapper > .owl-item:nth-of-type(1) .loader")
    private WebElement click;

    public static final By selectPeople = By.xpath("//input[@placeholder='0']");

    public HomePage(final WebDriver driver) {
        super(driver);
    }

    public void clickToBookHotel() {
        waitForLoad(driver);
        pageDown();
        hoverOver(hotelPicture);
        waitAndClick(click);
//        waitAndClick(bookHotelNow);
    }

    public void goTo() {
        driver.get(URL);
    }

    public void clickSignUp() {
        myAccountButton.click();
        signUpButton.click();
    }

    public void enterFirstName(String text) {
        firstName.sendKeys(text);

    }

    public void enterLastName(String text) {
        lastName.sendKeys(text);

    }

    public void enterMobile(String text) {
        mobileNumber.sendKeys(text);

    }

    public void enterEmail(String text) {
        email.sendKeys(text);
    }

    public void enterPassword1(String text) {
        password1.sendKeys(text);

    }

    public void enterPassword2(String text) {
        password2.sendKeys(text);
    }

    public void submitForm() {
        submitForm.click();
    }

    public void clickLogIn() {
        waitForLoad(driver);
//        try {
//            sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        myAccountButton.click();
        logInButton.click();
    }

    public void clickBookNow() {
        pageDown();
        pageDown();
        pageDown();
        bookNowButton.click();
    }

    public void clickFlightsButton() {
        flightsButton.click();
    }

    public void type(String text) {
        WebElement currentelement = driver.switchTo().activeElement();
        currentelement.sendKeys(text);
    }

    public WebElement setDay(String text) {
       return driver.findElement(By.linkText(text));
    }

    public void searchForFlight() {
        waitForLoad(driver);
        waitAndClick(from);
        from.sendKeys("Paris");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pressEnter();

        to.click();
//        to.sendKeys("London");
        type("London");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pressEnter();

        departDate.click();
        nextMonthButton.click();
//        setDay("6").click();
        testDate.click();

//        driver.findElement(selectPeople).click();

        passengers.sendKeys();
//        selectFromDropdown(adultDropdown, "3");
//        selectFromDropdown(childDropdown, "6");
//        selectFromDropdown(infantDropdown, "1");
        backspace();
        passengers.sendKeys("4");

        selectFromDropdownByValue(classDropdown, "business");

        flightSearch.click();
    }
    public void test() {
        waitAndClick(from);
        List<WebElement> calendars =
//                driver.findElements(By.xpath("/html/body/div[8]/div[1]/table/tbody/*"));
                driver.findElements(By.cssSelector("body > div:nth-child(15) > div.datepicker-days > table > tbody"));

        for (WebElement thisCal : calendars) {
            System.out.println("A list of dates: " + thisCal.getText());
            if (thisCal.getText().contains("20")) {
                thisCal.findElement(By.xpath("//td[contains(text(),'20')]")).click();
                break;
            }
        }
    }



}
