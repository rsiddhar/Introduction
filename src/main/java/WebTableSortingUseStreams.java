import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSortingUseStreams {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RSIDDHAR\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        //capture all the web elements in list
        //capture text of all web elements into new list(original list)
        //apply sort on the origianl list of step3 -> sorted list
        //compare original list and sorted list

        //click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all the web elements in list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //capture text of all web elements into new list(original list)
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //apply sort on the origianl list of step3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(sortedList));



        //get the price of rice
            //scan the name column with getText -> Beans
            //print the price of the rice
        List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a->System.out.println(a));

    }
    private static String getPriceVeggie(WebElement s){
        String pricevalue = s.findElement(By.xpath("/following-sibling::td[1]")).getText();
        return pricevalue;
    };
}
