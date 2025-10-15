import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class BrowserOptions {
    WebDriver driver;

    @Test
    public void browserOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        driver.get("https://www.google.com/");
        options.setBrowserVersion("latest");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setAcceptInsecureCerts(true);
        
    }
}
