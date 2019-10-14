import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPage {
    AdminPage1 object=new AdminPage1();

    String emailid="(//input[@placeholder='Email'])[1]";
    String passwrd="//input[@placeholder='Password']";
    String carlink="(//a[contains(text(),'Cars')])[1]";
    String car="(//a[contains(text(),'Cars')])[2]";
    String verifydata="//p[contains(text(),'DASHBOARD')]";
    String pickup="(//span[contains(text(),'Enter Location')])[1]";
    String drop="(//span[contains(text(),'Enter Location')])[2]";
    String edit="//a[contains(text(),'Toyota Camry 2015 full option')]";
    String location1="(//div[@class='select2-result-label'])[1]";
    String location2="//div[@class='select2-result-label']";
    String submitbtn="//button[@id='update']";
    String verifydata1="//h4[contains(text(),'Changes Saved')]";
    String loginbtn="//button[@type='submit']";
    String enter="(//span[@class='select2-chosen'])[6]";
    String enter1="(//div[@class='select2-container'])[6]";
    String popup="//[@id='livechat-eye-catcher']/div[1]";

    WebDriver driver=null;

    @BeforeClass
    public void startup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.phptravels.net/admin");
        Reporter.log("Browser open!");
        driver.manage().window().maximize();
        Reporter.log("Window maximize!");
    }

    @Test
    public void main()
    {
        object.sendkey(driver,emailid,"admin@phptravels.com");
        Reporter.log("Enter EmailId!");
        object.sendkey(driver,passwrd,"demoadmin");
        Reporter.log("Enter Password!");
        object.click(driver,loginbtn);
        Reporter.log("Click on login button");
        object.Wait(2) ;
        object.verify(driver,verifydata,"DASHBOARD");
        Reporter.log("Verify Home Page!");
        object.Wait(2) ;
        object.scrollingToElement(driver,carlink);
        Reporter.log("Scroll window by element!");
        object.Wait(2) ;
        object.click(driver,carlink);
        object.click(driver,car);
        object.Wait(2) ;
        object.click(driver,edit);
        Reporter.log("Click on Edit button on particular link");
        object.Wait(2) ;
        object.scrollingToElement(driver,pickup);
        System.out.println("Scroll by element");
        object.Wait(2) ;
       /* object.click(driver,popup);
        object.Wait(2) ;

        object.click(driver,enter);

        System.out.println("Pickup location found");
        object.Wait(2) ;
        object.sendkey(driver,pickup,"Ahmedabad");
        object.Wait(2) ;
        object.click(driver,location1);

        object.sendkey(driver,drop,"Vadodara");
        object.click(driver,location2);
        object.Wait(2) ;
        object.scroll(driver,0,300);
        System.out.println("Scroll to bottom");
*/
        object.scroll(driver,0,1200);
        object.click(driver,submitbtn);
        Reporter.log("Click on submit button!");
        object.Wait(2) ;
        object.verify(driver,verifydata1,"CHANGES SAVED!");
        Reporter.log("Verify Changes Saved");
    }

    @AfterClass
    public void end()
    {
        object.close(driver);
    }
}
