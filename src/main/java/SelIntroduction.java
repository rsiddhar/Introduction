import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction{
    public static void main(String[] args){

        //invoking browser
        //Chrome - ChromeDriver -> Methods close get
        //Firefox - FirefoxDriver -> Methods close get
        //Safari - SafariDriver -> Methods close get
        //WebDriver is an Interface close get
        //WebDriver methods + class method

        //ChromeDriver is responsible for invoking the browser and there is a selenium manager which is taking care of that by default invoke and make our browser ready.
        //And you can disable Selenium manager and you can provide your own step by downloading the file of that compatible chrome driver and making the chrome driver run.

        //step to invoke chrome driver
        //Selenium Manager
        //Chromedriver.exe -> Chrome browser
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();


        //Firefox Launch
        //geckodriver
        //webdriver.gecko.driver
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();


        //Microsoft edge
        //webdriver.msedgedrive.driver
        System.setProperty("webdriver.edge.driver","C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();


        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }
}
