import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7WebTables {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        //no of rows
        System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());

        //no of coloumns
        System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[1]/th")).size());

        //details 2nd row
        List<WebElement> details = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));

        for(int i=0; i<details.size(); i++){
            System.out.println(details.get(i).getText());
        }
    }
}
