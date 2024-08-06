import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Assignment3ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Instantiate WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
        driver.findElement(By.xpath("//label[@class='customradio']/span[text()=' User']/following-sibling::input")).click();

        WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("consult");

        // Wait until the modal dialog appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
        driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
        // Wait until the modal dialog disappears
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal")));

        // Click the checkbox after the modal dialog disappears
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

        //adding items to cart
        String[] itemsNeeded = {"iphone X", "Samsung Note 8"};
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a")));
        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']/a"));

        int j = 0;
        for(int i=0; i<products.size(); i++){
            String name = products.get(i).getText();
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);
            if(itemsNeededList.contains(name)){
                j++;
                driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
                if(j == itemsNeeded.length){
                    break;
                }
            }
        }



        //clicking on checkout btn
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.findElement(By.cssSelector("td button[class='btn btn-success']")).click();


        //Selecting country from suggestions
        driver.findElement(By.cssSelector("#country")).sendKeys("ind");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".suggestions ul li a")));
        List<WebElement> options = driver.findElements(By.cssSelector(".suggestions ul li a"));

        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;

            }
        }

        //click on agree and then purchase
        driver.findElement(By.xpath("//label[@for='checkbox2']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(), "×\n" +
                "Success! Thank you! Your order will be delivered in next few weeks :-).");
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());


    }
}
