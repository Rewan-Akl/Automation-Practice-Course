import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {
    WebDriver driver;
    By startButton = By.tagName("button");
    By msg = By.cssSelector("#finish > h4");
    @Test
    public void implicitWait(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //implicit wait
       driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
       driver.findElement(startButton).click();
       String message= driver.findElement(msg).getText();
        System.out.println(message);

    }
    @Test
    public void explicitWait (){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(msg));     // using expected conditions
        String message= driver.findElement(msg).getText();
        System.out.println(message);
    }
    @Test
    public void explicitWaitUsingLambda (){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(driver1 -> driver.findElement(msg).isDisplayed());     // using lambda
        String message= driver.findElement(msg).getText();
        System.out.println(message);
    }
    @Test
    public void fluentWait(){
        //page load strategy
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver= new EdgeDriver(edgeOptions);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(startButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300L))
                .withMessage("element is not visible, locator " + msg.toString())
                .ignoring(NoSuchElementException.class)
                .until(driver1 -> driver.findElement(msg).isDisplayed());
        String message= driver.findElement(msg).getText();
        System.out.println(message);

    }
}
