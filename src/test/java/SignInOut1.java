import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInOut1 {
    public void click(WebDriver driver, String path)
    {
        driver.findElement(By.xpath(path)).click();
        System.out.println("Click Method Calling......");
    }
    public void verify(WebDriver driver,String path,String value)
    {
        String val=driver.findElement(By.xpath(path)).getText();
        Assert.assertEquals(val,value);

        String val1=driver.findElement(By.xpath(path)).getText();
        Assert.assertEquals(val1,value);
        System.out.println("Verify Method Calling.....");

    }
    public void sendkey(WebDriver driver, String path, String Value)
    {
        driver.findElement(By.xpath(path)).sendKeys(Value);
        System.out.println("Sendkey Method Calling.....");

    }
    public void Wait(int sec)
    {
        int milisecond=sec*1000;
        try {
            Thread.sleep(milisecond);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void close(WebDriver driver)
    {
        System.out.println("Close Method Calling.....");

        driver.close();
    }
}
