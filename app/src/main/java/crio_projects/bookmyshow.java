package crio_projects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bookmyshow {
    ChromeDriver driver;
    public bookmyshow(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void bookmyshow(){
        System.out.println("Start Test case: testCase01");
        // naviagte to https://in.bookmyshow.com/explore/home/chennai using get method  https://in.bookmyshow.com/explore/home/chennai
       driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find the number of hyperlinks present in that page using tagname "a" and save to a list Using Locator "Tag Name" driver.findElements(By.TagName('a'))
       List<WebElement> movi =  driver.findElements(By.tagName("a"));
        // count the number of items in the list using .size() method  
        int count = movi.size();
        // print the value of the count  
        System.out.println("there are total  " + count + "  links present");
    }
}