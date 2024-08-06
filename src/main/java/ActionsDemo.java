import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.purplle.com/");
        Actions a = new Actions(driver);

        WebElement move = driver.findElement(By.xpath("//div[@class='position-relative']"));

        a.moveToElement(driver.findElement(By.cssSelector("input[type='search']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //Moves to specific element
        a.moveToElement(move).contextClick().build().perform();
    }
}
