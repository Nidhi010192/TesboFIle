import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {

    Login1 log=new Login1();

    String email="//input[@id='identifierId']";
    String passwd="//input[@name='password']";
    String next="//span[contains(text(),'Next')]";
    String verifytext="//span[contains(text(),'Sign in')]";
    String verifytext1="//a[@title='Inbox']";
    WebDriver driver=null;

    @BeforeClass
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://gmail.com");
        Reporter.log("Browser Opened");
        driver.manage().window().maximize();

    }

    @Test
    public void main()
    {
        log.verify(driver,verifytext,"Sign in");
        Reporter.log("Home page text verify !");
        log.sendkey(driver,email,"ankitmistry@qable.io");
        Reporter.log("Enter EmailId Sucessfully! ");
        log.click(driver,next);
        Reporter.log("Click on next button");
        log.Wait(2) ;
        log.sendkey(driver,passwd,"aki26991");
        Reporter.log("Enter Password sucessfully");
        log.click(driver,next);
        Reporter.log("Enter on Login button!");
        log.Wait(2) ;
        log.verify(driver,verifytext1,"Inbox");
        Reporter.log("After login text verify !");
    }

    @AfterClass
     public void end()
    {
        log.close(driver);
        Reporter.log("Browser closed");
    }
}
