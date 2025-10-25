import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecuter {
    WebDriver driver;

    @Test
    public void JS() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/scrolling.html");
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("scroll_text")));
    }
}
