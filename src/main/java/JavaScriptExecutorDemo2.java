import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptExecutorDemo2 {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        List<WebElement> values = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
        int sum =0;
        for(int i=0; i<values.size(); i++){
            sum = sum + Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);

    }
}
