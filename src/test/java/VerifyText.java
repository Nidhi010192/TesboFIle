import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyText {

    VerifyText1 object=new VerifyText1();
    WebDriver driver=null;

    String verify1="//a[@title='Mail']";
    String verify2="//span[contains(text(),'Hotels')]";



    @BeforeClass
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.net");
        Reporter.log("Browser Open");
        driver.manage().window().maximize();
        Reporter.log("Window maximize");

    }

    @Test
    public void main() {
        object.equalsTo(driver, verify1, "info@travelagency.com");
        System.out.println("Text is equals to");
        Reporter.log("Verify Text Is equal to!");

        object.NotequalsTo(driver, verify2, "Hotels");
        System.out.println("Text is not equal to");
        Reporter.log("Verify text is not equal to!");

        object.IgnoreCase(driver, verify2, "Hotels");
        System.out.println("Text is equals & Ignorecase");
        Reporter.log("Verify text is equal to & Ignore case");
    }

    @AfterClass
    public void end()
    {
        object.close(driver);
        Reporter.log("Browser Close");

    }
}
