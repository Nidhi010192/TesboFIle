import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 public class Changepasswrd {
    Changepasswrd1 object=new Changepasswrd1();

     String myaccount="(//a[contains(text(),'My Account')])[2]";
     String verifydata="//a[@title='Mail']";
     String loginpage="(//a[contains(text(),'Login')])[2]";
     String verifydata1="//div[contains(text(),'Login')]";
     String emailid="//input[@placeholder='Email']";
     String passwrd="//input[@placeholder='Password']";
     String loginbtn="(//button[@type='submit'])[1]";
     String forgetpasswrd="//a[contains(text(),'Forget Password')]";
     String newemail="//input[@placeholder='your@email.com']";
     String date="//span[@class='h4']";
     String time="//div[@id='txt']";
     String dropdown="(//a[@data-toggle='dropdown'])[4]";
     String logout="(//a[contains(text(),'Logout')])[2]";
     String resetpasswrd="//input[@placeholder='your@email.com']";
     String resetbtn="(//button[@type='submit'])[2]";
     String closebtn="//button[@class='close']";


    WebDriver driver=null;

    @BeforeClass
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.net");
        Reporter.log("Browser Open");
        driver.manage().window().maximize();
        Reporter.log("Browser Maximize");
    }

    @Test
    public void main()
    {
        object.verify(driver,verifydata,"info@travelagency.com");
        Reporter.log("Home page verify!");
        object.Wait(2) ;
        object.click(driver,myaccount);
        object.click(driver,loginpage);
        object.Wait(2) ;
        object.verify(driver,verifydata1,"LOGIN");
        Reporter.log("Login page verify!");
        object.sendkey(driver,emailid,"user@phptravels.com");
        Reporter.log("Enter EmailId");
        object.sendkey(driver,passwrd,"demouser");
        Reporter.log("Enter Password");
        object.Wait(2) ;

        object.scroll(driver,0,300);
        System.out.println("Scroll to bottom");
        Reporter.log("Scroll to bottom!");
        object.click(driver,loginbtn);
        object.Wait(2) ;
        Reporter.log("Click on login button!");

        System.out.println("Today Date is: " +object.retrieve(driver,date));
        System.out.println("Current Time is : " +object.retrieve(driver,time));
        Reporter.log("Fetch current date and time!");
        object.Wait(2) ;
        object.click(driver,dropdown);
        object.click(driver,logout);
        Reporter.log("Logout Sucessfully!");
        System.out.println("Logout Sucessfully");
        object.Wait(2) ;
        object.scrollingToElement(driver,forgetpasswrd);
        System.out.println("Scroll by element");
        Reporter.log("Scroll by element!");
        object.Wait(2) ;
        object.click(driver,forgetpasswrd);
        object.sendkey(driver,resetpasswrd,"user@phptravels.com");
        Reporter.log("Enter email for Reset!");
        object.click(driver,resetbtn);
        object.Wait(2) ;
        object.click(driver,closebtn);


    }

    @AfterClass
    public void end()
    {
        object.close(driver);
    }
}
