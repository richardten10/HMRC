package uk.co.testcraft.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy (css=".panel-body [type='email']")
    WebElement email;

    @FindBy (css="[type='password']")
    WebElement password;

    @FindBy (css="[data-wow-duration] button")
    WebElement loginButton;

    @FindBy (css = "#loginfrm > div.panel.panel-default > div.resultlogin > div")
    WebElement errorMessage;

    public void login(String emailToEnter, String passwordToEnter) {
        email.sendKeys(emailToEnter);
        password.sendKeys(passwordToEnter);
        loginButton.click();
    }

    public void assertErrorShown(String message){
        Assert.assertEquals(message, errorMessage.getText());
    }

}
