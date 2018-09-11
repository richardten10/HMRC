package uk.co.testcraft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    public SignUpPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[method] .form-group:nth-of-type(3) .form-control")
    private WebElement firstName;

    @FindBy(css = "[method] .form-group:nth-of-type(4) .form-control")
    private WebElement lastName;

    @FindBy(css = "[method] .form-group:nth-of-type(5) .form-control")
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

}

