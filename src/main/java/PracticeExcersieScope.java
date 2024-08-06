import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PracticeExcersieScope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1. Give me the count of links on the page.
        //a -> anchor tag
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());


        //2.count of links in footer sections.
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());


        //3. In the footer section count the link only in the first coloumn
        WebElement colomnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(colomnDriver.findElements(By.tagName("a")).size());


        //4. click on each link in the coloumn and check if the pages are opening.
        for(int i=1; i<colomnDriver.findElements(By.tagName("a")).size(); i++){
            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            colomnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
        }

        Thread.sleep(5000L);

        //5. Iterating through every window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


    }
}
