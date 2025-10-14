import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {
    WebDriver driver;
    By dropDown = By.id("dropdown");

    @Test
    public void Dropdown(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        new Select(driver.findElement(dropDown)).selectByVisibleText("Option 1");

    }
}
