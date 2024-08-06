import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //applies to every single line
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);t    //deprecated
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //expected products array
        String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Carrot"};

        Thread.sleep(2000);

        addItems(driver, itemsNeeded);

        //Click on cart img after selecting the items
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());



    }
    public static void addItems(WebDriver driver, String[] itemsNeeded){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;
        for(int i=0; i<products.size(); i++) {

            String[] name = products.get(i).getText().split("-");
            //name[0] => Brocolli
            //name[1] =>  1 kg
            String formattedName = name[0].trim();

            //format name to get actual vegetable name --> Brocolli - 1 Kg ==> Brocolli
            //check whether name you extracted in present in array or not.
            //convert array into arraylist for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                //click on Add to cart
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
