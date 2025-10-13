import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckboxAndRadiobutton {
    WebDriver driver;
    By notFanCheckbox = By.id("noClub");
    By ahlyCheckbox = By.id("Ahly");
    By gradSchoolRadioButton = By.id("radio-button-3");

    @Test
    public void Checkbox (){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/checkbox_Radio.html");
        System.out.println("Checked: " + driver.findElement(ahlyCheckbox).isSelected());
        //driver.findElement(notFanCheckbox).click();
        if (!driver.findElement(ahlyCheckbox).isSelected()){
            driver.findElement(ahlyCheckbox).click();
        }
    }
    @Test
    public void radioButton(){
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/checkbox_Radio.html");
        if (driver.findElement(gradSchoolRadioButton).isSelected()){
            System.out.println(driver.findElement(gradSchoolRadioButton).isSelected());
        }
        else {
            driver.findElement(gradSchoolRadioButton).click();
        }
    }
}
