import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

import java.io.File;

public class ElementActions {
    WebDriver driver;
    By userName = By.id("inputUsername");
    By Password = By.id("inputPassword");
    By loginButton = By.id("loginButton");
    By loginFields = new ByAll(By.id("inputUsername"), By.id("inputPassword"), By.id("loginButton"));
    By uploadFilesLink = By.partialLinkText("Upload");
    By chooseFilesButton = By.id("regularFileInput");


    @Test
    public void login() {
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

    @Test
    public void uploadFileTC() {
        driver = new EdgeDriver();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().window().maximize();
        driver.findElement(userName).sendKeys("admin");
        driver.findElement(Password).sendKeys("admin");
        driver.findElement(loginButton).submit();
        driver.findElement(uploadFilesLink).click();
        String userHome = System.getProperty("user.dir");
        driver.findElement(chooseFilesButton).sendKeys(userHome + File.separator + "src\\test\\resources\\test.txt");

    }

    @Test  //After using functions
    public void uploadFileAfterUsingFunctions() {
        driver = new EdgeDriver();
        navigateTo("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().window().maximize();
        type(userName, "admin");
        type(Password, "admin");
        clicking(loginButton);
        clicking(uploadFilesLink);
        uploadFile(chooseFilesButton, "src\\test\\resources\\test.txt");
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public void clicking(By by) {
        driver.findElement(by).click();
    }

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    public void uploadFile(By by, String filePath) {
        String userHome = System.getProperty("user.dir");
        driver.findElement(by).sendKeys(userHome + File.separator + filePath);

    }
}
