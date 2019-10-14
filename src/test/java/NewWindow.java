import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindow {

    NewWindow1 object=new NewWindow1();

    String myaccount="(//a[contains(text(),'My Account')])[2]";
    String signup="(//a[contains(text(),'Sign Up')])[2]";
    String verifytext="//a[@title='Mail']";
    String verifytext1="//label[contains(text(),'First Name')]";
    String firstname="//input[@placeholder='First Name']";
    String lastname="//input[@placeholder='Last Name']";
    String mobileno="//input[@placeholder='Mobile Number']";
    String email="//input[@placeholder='Email']";
    String passwrd="//input[@placeholder='Password']";
    String confirmpasswrd="//input[@placeholder='Confirm Password']";
    String signupbtn="//button[contains(text(),' Sign Up')]";

    WebDriver driver=null;

    @BeforeMethod
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.net");
        Reporter.log("Browser Opened");
        driver.manage().window().maximize();
        Reporter.log("Window maximize");
    }

    @Test
    public void main()
    {
        object.Wait(2) ;

        //Verify Text on HomePage
        object.verify(driver,verifytext,"info@travelagency.com");
        Reporter.log("Verify homepage text verify!");
        System.out.println("Home Page is display");
        object.Wait(2) ;
        //Click on MyAccount Dropdown box
        object.click(driver,myaccount);


        //Click on SignUp Link
        object.click(driver,signup);

        //Verify Text on SingUp Page
        object.verify(driver,verifytext1,"First Name");
        Reporter.log("Verify signup page text!");
        System.out.println("Verify Signup page is displayed");


        //Fillup SignUp form
        object.sendkey(driver,firstname,"Test");
        object.sendkey(driver,lastname,"Test");
        object.sendkey(driver,mobileno,"99012001122");
        object.sendkey(driver,email,"testingqable@yopmail.com");
        object.sendkey(driver,passwrd,"12345");
        object.sendkey(driver,confirmpasswrd,"12345");
        System.out.println("Data fillup into form");
        Reporter.log("Fillup data into form!!");
        object.Wait(2) ;
        object.click(driver,signupbtn);
        Reporter.log("Registration Sucessfully done");
        System.out.println("Registration Sucessfully done");
    }

    @AfterMethod
    public void end()
    {
        object.close(driver);
        Reporter.log("Browser close");
    }

}
