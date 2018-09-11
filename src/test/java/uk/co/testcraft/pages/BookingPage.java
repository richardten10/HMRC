package uk.co.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

public class BookingPage extends AbstractPage {

    public BookingPage(final WebDriver driver) {
        super(driver);
    }

    DateTimeFormatter getDays = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter getMonth = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter getYear = DateTimeFormatter.ofPattern("yyyy");

    @FindBy(css = "#body-section [class='col-md-4'] [name]")
    private WebElement selectDateButton;

    @FindBy(name = "adults")
    private WebElement adultsDropdown;

    @FindBy(name = "child")
    private WebElement childrenDropdown;

    @FindBy(name = "infant")
    private WebElement infantDropDown;

    @FindBy(xpath = "//div[@id='body-section']/div[3]/div[@class='panel panel-default']//form[@role='search']//button[@type='submit']")
    private WebElement bookNowButton;

    @FindBy(css = "#guestform .form-group:nth-of-type(1) [class='col-md-5 col-xs-12']:nth-of-type(2) .form-control")
    private WebElement firstName;

    @FindBy(css = "#guestform .form-group:nth-of-type(1) [class='col-md-5 col-xs-12']:nth-of-type(3) .form-control")
    private WebElement lastName;

    @FindBy(css = "#guestform .form-group:nth-of-type(2) [class='col-md-5 col-xs-12']:nth-of-type(2) .form-control")
    private WebElement email;

    @FindBy(css = "#guestform .form-group:nth-of-type(2) [class='col-md-5 col-xs-12']:nth-of-type(3) .form-control")
    private WebElement confirmEmail;

    @FindBy(css = "#guestform .form-group:nth-of-type(3) .form-control")
    private WebElement contactNumber;

    @FindBy(css = "#guestform .form-group:nth-of-type(4) .form-control")
    private WebElement address;

    @FindBy(css = "[href='javascript\\:void\\(0\\)']")
    private WebElement selectCountry;

    @FindBy(css = ".select2-chosen")
    private WebElement selectCountry2;

    @FindBy(css = "[class='col-md-8 offset-0 go-right'] button")
    private WebElement confirmBooking;

    @FindBy(css = "#load_data tr:nth-of-type(1) button")
    private WebElement bookNow;

    @FindBy(css = "tr:nth-of-type(1) [type='submit']")
    private WebElement hotelBookNowWithDates;

    @FindBy(css = "[name] [class='col-md-3 col-xs-12 go-right']:nth-of-type(1) [type]")
    private WebElement checkInDate;

    @FindBy(css = "[name] [class='col-md-3 col-xs-12 go-right']:nth-of-type(2) [type]")
    private WebElement checkOutDate;

    @FindBy(css = "body .dropdown-menu:nth-child(14) tr:nth-of-type(5) .day:nth-of-type(6)")
    private WebElement checkInPick;

    @FindBy(css = "body .dropdown-menu:nth-child(15) .datepicker-days [colspan]")
    private WebElement monthAndYear;

    @FindBy(xpath = "//body/div[9]/div[@class='datepicker-days']/table//th[@class='next']")
    private WebElement nextMonthButton;


    public void changeDate() {
        //  todo
    }

    public void enterPeople(String adultAmount, String childAmount, String infantAmount) {
        pageDown();
        pageDown();
        selectFromDropdown(adultsDropdown, adultAmount);
        selectFromDropdown(childrenDropdown, childAmount);
        selectFromDropdown(infantDropDown, infantAmount);
    }

    public void clickBookNow() {
        bookNowButton.click();
    }

    public void fillInPersonalDetailsPage() {
        firstName.sendKeys("firstname");
        lastName.sendKeys("secondname");
        email.sendKeys("billy.mcgill@gmail.com");
        confirmEmail.sendKeys("billy.mcgill@gmail.com");
        contactNumber.sendKeys("07982140127");
        address.sendKeys("23 road");
        selectCountry2.click();
        type("United Kingdom");
//        selectCountry2.sendKeys("United Kingdom");
        pressEnter();
    }

    public void confirmBooking() {
        pageDown();
        pageDown();
        pageDown();
        waitAndClick(confirmBooking);
    }

    public void clickBookNowFlights() {
        pageDown();
        waitAndClick(bookNow);
    }

    public void enterHotelDate1() {
        pageDown();
        pageDown();

        selectFromDropdownByValue(adultsDropdown, "4");
        selectFromDropdownByValue(childrenDropdown, "3");

        waitAndClick(checkInDate);
//        waitAndClick(checkInPick);
        waitAndClick(checkOutDate);


    }

    public void enterHotelDate2(int daysToAdd) {
        LocalDate startDate = LocalDate.now().plusDays(daysToAdd);
        String days = startDate.format(getDays);
        String month = startDate.format(getMonth);
        String year = startDate.format(getYear);
        String convertedMonth = convertMonth(month);
        int newDay = Integer.parseInt(days);
        String newDayAsString = Integer.toString(newDay);
//        Assert.assertEquals(newDayAsString, "s");
//        Assert.assertEquals(convertedMonth, "d");

        List<WebElement> calendars = driver.findElements(By.cssSelector("body > div:nth-child(15) > div.datepicker-days > table > tbody"));

        List<String> textList = new ArrayList<>();
        for (WebElement each: calendars) {
            textList.add(each.getText());
        }

        while (!(monthAndYear.getText().contains(convertedMonth) && monthAndYear.getText().contains(year))) {
            waitAndClick(nextMonthButton);
        }
        if (newDayAsString == "1") {
            one.click();
        }
//        waitAndClick(driver.findElement(By.cssSelector("body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(5) > td:nth-child(1)\n")));
//        waitAndClick(driver.findElement(By.cssSelector(returnDayToClick("5", "1"))));
        waitAndClick(driver.findElement(By.cssSelector(checkAllDates(newDayAsString))));
    }

    private static String[][] Matrix = new String[6][7];

    public String checkAllDates(String day) {
        WebElement element = driver.findElement(By.cssSelector(".btn-success-small"));
        String element1 = "";
        for (int i = 1; i<Matrix.length; i++ ) {
            for(int j=1; j<Matrix[i].length; j++) {
//                System.out.println((returnDayToClick(Integer.toString(i), Integer.toString(j)).getText()));
//                Assert.assertEquals(returnDayToClick(Integer.toString(i), Integer.toString(j)).getText(), "26");
                if (driver.findElement(By.cssSelector(returnDayToClick(Integer.toString(i), Integer.toString(j)))).getText().contains(day)) {
//                    try {
//                        sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    element = (driver.findElement(By.cssSelector(returnDayToClick(Integer.toString(i), Integer.toString(j)))));
                    element1 = returnDayToClick(Integer.toString(i), Integer.toString(j));
                    System.out.println(element.getText());
                break;
               }
            }
    }
    return element1;
    }
//
//    public void printAndClickDate() {
////        driver.findElement(By.cssSelector("body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(5)")).click();
//        List<WebElement> calendars =
////                driver.findElements(By.xpath("/html/body/div[8]/div[1]/table/tbody/*"));
//                driver.findElements(By.cssSelector("body > div:nth-child(15) > div.datepicker-days > table > tbody"));
//
//        for (WebElement thisCal : calendars) {
//            System.out.println("A list of dates: " + thisCal.getText());
//            if (thisCal.getText().contains("20")) {
//                thisCal.findElement(By.xpath("//td[contains(text(),'20')]")).click();
//                break;
//            }
//        }
//    }

        public String convertMonth(String month) {
        String newMonth = "";
        switch (month) {
        case "01": newMonth = "January";
        case "02": newMonth = "February";
        case "03": newMonth = "March";
        case "04": newMonth = "April";
        case "05": newMonth = "May";
        case "06": newMonth = "June";
        case "07": newMonth = "July";
        case "08": newMonth = "August";
        case "09": newMonth = "September";
        case "10": newMonth = "October";
        case "11": newMonth = "November";
        case "12": newMonth = "December";
        }
        return newMonth;
    }

    public void findEndDate(int y) {
        LocalDate endDate = LocalDate.now().plusDays(y);
        String days =  endDate.format(getDays);
        String month = endDate.format(getMonth);
        String year = endDate.format(getYear);
    }


    public void clickBookHotelNow() {
        waitAndClick(hotelBookNowWithDates);
    }

    public String getMonthAndYear() {
        return monthAndYear.getText();
    }

    @FindBy (css = "body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(1) > td.day.active")
    private WebElement one;

    @FindBy (css = "body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(2) > td.day.active")
    private WebElement two;

    @FindBy (css = "body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(3) > td.day.active")
    private WebElement three;

    @FindBy (css = "body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(4) > td.day.active")
    private WebElement four;

    @FindBy (css = "body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(5) > td.day.active")
    private WebElement five;

    @FindBy (css = "body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(6) > td.day.active")
    private WebElement six;

    public String findFirstActive() {
        String firstValue = "";
        try {
            hoverOver(one);
            firstValue = one.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            hoverOver(two);
            firstValue = two.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            hoverOver(three);
            firstValue = three.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            hoverOver(four);
            firstValue = four.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            hoverOver(five);
            firstValue = five.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            hoverOver(six);
            firstValue = six.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return firstValue;
    }

    public int findDaysToAdd(int daysToAdd){
        int i = daysToAdd - Integer.parseInt(findFirstActive());
        return i;
    }

    public String returnDayToClick(String row, String column) {
        StringBuilder builder = new StringBuilder();
        builder.append("body > div:nth-child(15) > div.datepicker-days > table > tbody > tr:nth-child(");
        builder.append(row);
        builder.append(") > td:nth-child(");
        builder.append(column);
        builder.append(")");
//        Assert.assertEquals(builder.toString(), "ds");
        WebElement element = driver.findElement(By.cssSelector(builder.toString()));
        System.out.println(builder.toString());
        System.out.println(element.getText());
        return builder.toString();
    }







}