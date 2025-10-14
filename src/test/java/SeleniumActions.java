import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumActions {
    WebDriver driver;
    By rightClickButton = By.id("riClickBtn");
    By avatarHover = By.cssSelector("[alt='User Avatar']");
    By doubleClickButton = By.id("dblClickBtn");
    By imageDrag = By.cssSelector("[alt='my Image']");
    By dropField = By.id("dropZone");

    @Test
    public void contextClick(){            // Right click
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/mouse.html");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightClickButton))
                .perform();
    }
    @Test
    public void Hovering(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(avatarHover))
                .perform();
    }
    @Test
    public void doubleClick (){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/mouse.html");
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleClickButton))
                .perform();
    }
    @Test
    public void dragAndDrop(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/dragDrop.html");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(imageDrag), driver.findElement(dropField))
                .perform();
    }
    @Test
    public void releaseAndHold(){    // Same as drag and drop but with more steps
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/dragDrop.html");
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(imageDrag)).moveToElement(driver.findElement(dropField)).release()
                .perform();
    }

}
