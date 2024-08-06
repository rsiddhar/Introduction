import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HeightWidthOfWebelements {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(3).getText();
        driver.switchTo().window(parentId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        //Get Height and Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());


    }


}
