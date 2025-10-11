import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

public class ElementActions {
    WebDriver driver;
    By userName = By.id("inputUsername");
    By Password = By.id("inputPassword");
    By loginButton = By.id("loginButton");
    By loginFields = new ByAll(By.id("inputUsername"), By.id("inputPassword"), By.id("loginButton"));


    @Test
    public void TestCase() {
        driver = new EdgeDriver();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().window().maximize();
        driver.findElement(userName).sendKeys("admin");
        driver.findElement(Password).sendKeys("admin");
        driver.findElement(userName).clear();
        driver.findElement(Password).clear();
        // To use byAll
        driver.findElements(loginFields).getFirst().sendKeys("admin");
        driver.findElements(loginFields).get(1).sendKeys("admin");  // by index
        driver.findElements(loginFields).getLast().click();

        //   driver.findElement(loginButton).click();


    }
}
