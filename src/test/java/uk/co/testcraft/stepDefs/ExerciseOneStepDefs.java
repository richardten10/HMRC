package uk.co.testcraft.stepDefs;

import cucumber.api.java8.En;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.testcraft.pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import cucumber.api.java8.En;
import uk.co.testcraft.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class ExerciseOneStepDefs implements En{

    private WebDriver driver = new ChromeDriver();


    HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    LoginPage loginPage =  new LoginPage(driver);
    BookingPage bookingPage = new BookingPage(driver);
    InvoicePage invoicePage = new InvoicePage(driver);

    public ExerciseOneStepDefs() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        Given("^I am on the PHP travels homepage$", () -> {
                homePage.goTo();
            });

            When("^I click sign up$", () -> {
                homePage.clickSignUp();
            });

            And("^I fill out the information$", () -> {
//                homePage.enterFirstName("Billy");
//                homePage.enterLastName("Smith");
//                homePage.enterMobile("07480311496");
//                homePage.enterEmail("billy.smith@gmail.com");
//                homePage.enterPassword1("password");
//                homePage.enterPassword2("password");
                signUpPage.enterFirstName("Billy");
                signUpPage.enterLastName("Smith");
                signUpPage.enterMobile("07480311496");
                signUpPage.enterEmail("billy.smith@gmail.com");
                signUpPage.enterPassword1("password");
                signUpPage.enterPassword2("password");

            });

            And("^I submit the form$", () -> {
//                homePage.submitForm();
                signUpPage.submitForm();
            });


            //2

        When("^I log in$", () -> {
            homePage.clickLogIn();
            loginPage.login("billy.smith@gmail.com", "password");
        });

        Then("^I will be on the profile page$", () -> {
            Assert.assertEquals("Login", profilePage.getTitle());
        });

        // 3

        When("^I click book now on one of the guided tours$", () -> {
//            homePage.pageDown();
//            homePage.pageDown();
//            homePage.pageDown();
            homePage.clickBookNow();

        });

        And("^I fill in the info and click book$", () -> {
//            homePage.pageDown();
//            homePage.pageDown();
//            bookingPage.changeDate(); // currently empty
            bookingPage.enterPeople("5", "3", "2");
            bookingPage.clickBookNow();
        });

        And("^I fill in the personal details page and submit$", () -> {
            bookingPage.fillInPersonalDetailsPage();
            bookingPage.confirmBooking();
        });

        Then("^I will be on the invoice page$", () -> {
//            sleep(5000);
            invoicePage.assertOnPage();
//            Assert.assertEquals("Invoice", invoicePage.getTitle());
        });

        //4
        When("^I click on the flights button$", () -> {
            homePage.clickFlightsButton();

        });

        And("^I Search for a flight$", () -> {
            homePage.searchForFlight();
        });

        And("^I click on book now$", () -> {
            bookingPage.clickBookNowFlights();
        });

        //5

        When("^I click book now on a hotel$", () -> {
//            homePage.test();
            homePage.clickToBookHotel();
        });

        And("^I enter date values$", () -> {
            bookingPage.enterHotelDate1();
            bookingPage.enterHotelDate2(12);
//            bookingPage.printAndClickDate();
        });

        And("^I click to book the hotel$", () -> {
            bookingPage.clickBookHotelNow();
        });

        Then("^the dates will be correct$", () -> {
            Assert.assertEquals("11/09/2018", invoicePage.getCheckInDate());
            Assert.assertEquals("12/09/2018", invoicePage.getCheckOutDate());

        });

        // 6

        When("^I click log in$", () -> {
        homePage.clickLogIn();

        });

        And("^I enter invalid information$", () -> {
            loginPage.login("billy.smith@@@@@@@2132131231233123gmail.com", "passw343243214234ord");
        });


        Then("^an error message will be shown$", () -> {
            loginPage.assertErrorShown("Invalid Email or Password");
        });

        }
        }







