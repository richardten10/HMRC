//package uk.co.testcraft.utils;
//
////import io.github.bonigarcia.wdm.ChromeDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class DriverFactory {
//
////    static {
////        ChromeDriverManager.getInstance().setup();
////    }
//
//    private WebDriver driver;
//
//    public WebDriver getDriver() {
//        if (driver == null) {
//            setDriver();
//        }
//        return driver;
//    }
//
//    private void setDriver() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Richard Rawson\\Downloads\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().deleteAllCookies();
//    }
//
//}

