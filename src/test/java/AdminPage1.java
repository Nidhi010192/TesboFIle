import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AdminPage1 {
    public void click(WebDriver driver, String path)
    {
        driver.findElement(By.xpath(path)).click();
        System.out.println("Click Method Call");
    }
    public void verify(WebDriver driver,String path,String value)
    {
        String val=driver.findElement(By.xpath(path)).getText();
        Assert.assertEquals(val,value);

        String val1=driver.findElement(By.xpath(path)).getText();
        Assert.assertEquals(val1,value);
        System.out.println("Verify Method Call");

    }
    public void sendkey(WebDriver driver, String path, String Value)
    {
        driver.findElement(By.xpath(path)).sendKeys(Value);
        System.out.println("Sendkey Method Call");

    }
    public void scroll(WebDriver driver,int x,int y)
    {
        System.out.println("Scroll Method Calling.....");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
    public void scrollingToElement(WebDriver driver, String path) {

        WebElement web=driver.findElement(By.xpath(path));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",  web);
        System.out.println("ScrolltoElement Method Calling.....");
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
        System.out.println("Close Method Call");

        driver.close();
    }

}
