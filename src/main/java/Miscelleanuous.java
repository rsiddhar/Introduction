import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Miscelleanuous {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdri ver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("sessionKey");

      //click on any link --> sometimes the page will logout the session
        //login page- verify login url


        driver.get("https://google.com");

        //Taking Screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\RSIDDHAR\\Pictures\\screenshot.png"));



        //Broken URL
        //step-1 Is to get all urls tied up to the links using selenium
        //Java methods will call URL's and gets you the status code...
        //if status code >400 then that url is not working -> link whick tied to url is broken.
        //a[href*='soapui']
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();    //URL(url) is the class here & openConnection is the method => after calling this the object return type is HttpURLConnection.
        conn.setRequestMethod("HEAD");
        conn.connect();
        int respCode = conn.getResponseCode();
        System.out.println(respCode);


    }
}
