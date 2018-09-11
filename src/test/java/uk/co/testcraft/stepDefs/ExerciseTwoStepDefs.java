//package uk.co.testcraft.stepDefs;
//
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//import uk.co.testcraft.pages.GooglePage;
//import cucumber.api.java8.En;
//import uk.co.testcraft.pages.HomePage;
//import uk.co.testcraft.pages.LoginPage;
//import uk.co.testcraft.pages.ProfilePage;
//
//import java.util.concurrent.TimeUnit;
//
//public class ExerciseTwoStepDefs implements En {
//
//    private WebDriver driver = new ChromeDriver();
//
//    HomePage homePage = new HomePage(driver);
//    ProfilePage profilePage = new ProfilePage(driver);
//    LoginPage loginPage =  new LoginPage(driver);
//
//    public ExerciseTwoStepDefs() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
////        Given("^I am on the PHP travels homepage$", () -> {
////            homePage.goTo();
////        });
//
//        When("^I log in$", () -> {
//            homePage.clickLogIn();
//            loginPage.login("billy.smith@gmail.com", "password");
//        });
//
//        Then("^I will be on the profile page$", () -> {
//            Assert.assertEquals("b", profilePage.getTitle());
//        });
//
//
//    }
//
//}
