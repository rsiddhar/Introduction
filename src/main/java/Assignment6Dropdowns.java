import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6Dropdowns {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();

        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(opt);

        driver.findElement(By.cssSelector(".pull-right #name")).sendKeys(opt);

        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(opt));

        driver.switchTo().alert().accept();

    }
}
