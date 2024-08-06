import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='checkbox-example'] //input[@id='checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());


        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }
}
