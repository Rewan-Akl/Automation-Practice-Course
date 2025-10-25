import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicLocators {
    WebDriver driver;

    @Test
    public void dynamicLocators() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/");
        chooseCategory("OpenJS Foundation");
        chooseSubCategory("Join");
    }

    // Don't forget waits with dynamic locators
    public void chooseCategory(String Category) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='" + Category + "']")))
                .perform();
    }

    public void chooseSubCategory(String SubCategory) {
        driver.findElement(By.xpath("//li[@class='dropdown'] //a[.='" + SubCategory + "']")).click();
    }
}
