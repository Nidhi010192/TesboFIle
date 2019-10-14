import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerifyText1 {


    public void click(WebDriver driver, String path)
    {
        driver.findElement(By.xpath(path)).click();
        System.out.println("Click Method Call");
    }

    public void equalsTo(WebDriver driver,String path,String value) {
        String val = driver.findElement(By.xpath(path)).getText();
        Assert.assertEquals(val, value);
        System.out.println("Verify EqualsTo Method Call");
    }

    public void NotequalsTo(WebDriver driver,String path,String value)
    {
        String val1=driver.findElement(By.xpath(path)).getText();
        Assert.assertNotEquals(val1,value);
        System.out.println("Verify NotEqualsTo Method Call");
    }
    public void IgnoreCase(WebDriver driver,String path,String text)
    {
        String val1=driver.findElement(By.xpath(path)).getText();
        val1.equalsIgnoreCase(text);
        System.out.println("Verify IgnoreCase Method Call");
    }

    public void close(WebDriver driver)
    {
        System.out.println("Close Method Call");
        driver.close();
    }

}
