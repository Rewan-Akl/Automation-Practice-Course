import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;
    By clickForAlertButton = By.cssSelector("[onclick=\"jsAlert()\"]");
    By clickForConfirmButton = By.cssSelector("[onclick=\"jsConfirm()\"]");
    By clickForPromptButton = By.cssSelector("[onclick=\"jsPrompt()\"]");

    @Test
    public void confirmAlert() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(clickForAlertButton).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void dismissAlert() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(clickForConfirmButton).click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void promptAlert() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(clickForPromptButton).click();
        driver.switchTo().alert().sendKeys("Rewan");
        driver.switchTo().alert().accept();
    }

    @Test
    public void getTextAlert() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(clickForAlertButton).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
    }
}
