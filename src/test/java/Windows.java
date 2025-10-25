import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Windows {
    WebDriver driver;
    By clickHereLink = By.partialLinkText("Here");
    By textInNewTab= By.cssSelector("body > .example > h3");

    @Test
    public void switchToNewTabWithoutWindowHandle(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(clickHereLink).click();
        System.out.println(driver.findElement(textInNewTab).getText());   // will fail (NoSuchElement) because driver can't see the new tab and interact with elements inside it
    }
    @Test
    public void switchToNewTabWithWindowHandle(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String parent = driver.getWindowHandle();   // the page I land on now
        driver.findElement(clickHereLink).click();
        String child = driver.getWindowHandles().toArray()[1].toString();      // all handles
        driver.switchTo().window(child);
        System.out.println(driver.findElement(textInNewTab).getText());
        // To return to parent
        driver.switchTo().window(parent);
        // or close but it will not be fine if I have more than 2 tabs and want to return to the first one
       // driver.close();
    }
}
