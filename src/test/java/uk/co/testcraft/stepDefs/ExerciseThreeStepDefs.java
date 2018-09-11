//package uk.co.testcraft.stepDefs;
//
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//
//import uk.co.testcraft.pages.*;
//import cucumber.api.java8.En;
//
//import java.util.concurrent.TimeUnit;
//
//public class ExerciseThreeStepDefs implements En  {
//
//    private WebDriver driver = new ChromeDriver();
//
//    HomePage homePage = new HomePage(driver);
//    ProfilePage profilePage = new ProfilePage(driver);
//    LoginPage loginPage =  new LoginPage(driver);
//    BookingPage bookingPage = new BookingPage(driver);
//    InvoicePage invoicePage = new InvoicePage(driver);
//
//
//    public ExerciseThreeStepDefs() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
////        Given("^I am on the PHP travels homepage$", () -> {
////            homePage.goTo();
////        });
//
//        When("^I click book now on one of the guided tours$", () -> {
//            homePage.pageDown();
//            homePage.pageDown();
//            homePage.clickBookNow();
//
//        });
//
//        And("^I fill in the info and click book$", () -> {
//            homePage.pageDown();
//            homePage.pageDown();
//            bookingPage.changeDate(); // currently empty
//            bookingPage.enterPeople("5", "3", "2");
//            bookingPage.clickBookNow();
//        });
//
//        And("^I fill in the personal details page and submit$", () -> {
//            bookingPage.fillInPersonalDetailsPage();
//            bookingPage.confirmBooking();
//        });
//
//        Then("^I will be on the invoice page$", () -> {
//            Assert.assertEquals("b", invoicePage.getTitle());
//        });
//
//
//    }
//
//}
