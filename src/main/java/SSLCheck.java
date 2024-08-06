import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class SSLCheck {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addExtensions("");
        //options.setCapability("proxy", value);

        //Proxy proxy = new Proxy();    //setting proxy
        //options.setCapability("proxy", proxy);
        //proxy.setHttpProxy("ipaddress:4444");

        //blocking popups
        //options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());



        //other options
    }
}
