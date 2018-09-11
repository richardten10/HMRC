package uk.co.testcraft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {

//    @FindBy(css = "#collapse [class='lightcaret mt-2 go-left']")
//    private WebElement myAccountButton;

    public ProfilePage(final WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void pageDown() {
        pageDown();
    }

    // assertions


}
