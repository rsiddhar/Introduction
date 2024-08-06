import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class SoftAssertion {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdri ver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //Broken URL
        //step-1 Is to get all urls tied up to the links using selenium
        //Java methods will call URL's and gets you the status code...
        //if status code >400 then that url is not working -> link whick tied to url is broken.
        //a[href*='soapui']
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();


        for(WebElement link : links){
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode < 400, "The link with Text "+ link.getText() + " is broken with " + respCode);
        }
        a.assertAll();

    }
}


