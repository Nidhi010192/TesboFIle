import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SignInOut {
    WebDriver driver=null;
    SignInOut1 object=new SignInOut1();

    String email="//input[@id='identifierId']";
    String passwd="//input[@name='password']";
    String next="//span[contains(text(),'Next')]";
    String verifytext="//span[contains(text(),'Sign in')]";
    String verifytext1="//a[@title='Inbox']";
    String logout="//a[@class='gb_B gb_Da gb_g']";
    String signout="//a[contains(text(),'Sign out')]";

    @BeforeClass
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://gmail.com");
        Reporter.log("Browser open");
        driver.manage().window().maximize();
        Reporter.log("Window Maximize");
        System.out.println("BeforeClass Call");
    }

    @Test
    public void main()
    {
        object.verify(driver,verifytext,"Sign in");
        Reporter.log("Verify text on home page.");
        System.out.println("SignIn page is displayed");
        object.sendkey(driver,email,"ankitmistry@qable.io");
        Reporter.log("Entered emailid !");
        object.click(driver,next);
        Reporter.log("Click on next button!");
        object.Wait(2) ;
        object.sendkey(driver,passwd,"aki26991");
        Reporter.log("Entered Password!");
        object.click(driver,next);
        Reporter.log("Click on signIn button");
        object.Wait(2) ;
        object.verify(driver,verifytext1,"Inbox");
        Reporter.log("Login sucessfully!!!!! Verify text after login..");

        System.out.println("Login Sucessfully");

        object.click(driver,logout);
        object.click(driver,signout);
        System.out.println("Logout Sucessfully");
        Reporter.log("Logout Sucessfully");
        object.Wait(2) ;
    }

    @AfterClass
    public void end()
    {
        object.close(driver);
        Reporter.log("Browser closed");


    }
}
