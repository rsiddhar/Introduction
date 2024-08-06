import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment8AutoComplete {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("united");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui-menu-item-wrapper")));

        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("United Kingdom (UK)")){
                option.click();
                break;
            }
        }


    }
}
