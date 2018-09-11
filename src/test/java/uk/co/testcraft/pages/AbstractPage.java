package uk.co.testcraft.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

import static java.lang.Thread.sleep;

public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;


    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 20);
    }

    public void quit() {
        this.driver.quit();
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    void selectFromDropdown(WebElement element, String string)  {
        element.click();
        Select select = new Select(element);
        select.selectByVisibleText(string);
    }

    void selectFromDropdownByValue(WebElement element, String string)  {
        element.click();
        Select select = new Select(element);
        select.selectByValue(string);
    }

    public void pressEnter() {
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.RETURN);
    }

    void pageDown () {
        WebElement currentelement = driver.switchTo().activeElement();
        currentelement.sendKeys(Keys.PAGE_DOWN);
    }

    void type (String text) {
        WebElement currentelement = driver.switchTo().activeElement();
        currentelement.sendKeys(text);
    }

    void hoverOverAndClick(WebElement element) {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .click()
                .build();
        mouseOverHome.perform();
    }

    void hoverOver(WebElement element) {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(element)
                .build();
        mouseOverHome.perform();
    }

    void backspace() {
        WebElement currentelement = driver.switchTo().activeElement();
        currentelement.sendKeys(Keys.BACK_SPACE);
    }

}
