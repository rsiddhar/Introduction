import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("//form/div[1]/input[@type='text']")).sendKeys("Siddhartha");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("siddhartha@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("siddhartha123");
        driver.findElement(By.xpath("//div[@class='form-check']/input[@id='exampleCheck1']")).click();

        WebElement staticDropdown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("Male");

        driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("08-09-2000");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //System.out.println(driver.findElement(By.cssSelector("div[class*='alert']")).getText());  //Or
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText());

    }
}
