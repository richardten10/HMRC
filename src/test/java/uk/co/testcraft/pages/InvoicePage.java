package uk.co.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvoicePage extends AbstractPage {

    public InvoicePage(final WebDriver driver) {
        super(driver);
    }


public String getTitle() {
    return driver.getTitle();
}


@FindBy (css ="#invoiceTable > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(2) > td > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2)")
private WebElement checkInDate;

    @FindBy (css ="#invoiceTable > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(2) > td > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2)")
    private WebElement checkOutDate;

    @FindBy (css = "[class='col-md-8'] .btn-primary")
    private WebElement button;

    public String getCheckInDate() {
        return checkInDate.getText();
    }

    public String getCheckOutDate() {
        return checkOutDate.getText();
    }

    public void assertOnPage() {
        waitForLoad(driver);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Assert.assertEquals("Invoice", driver.getTitle());
    }

}