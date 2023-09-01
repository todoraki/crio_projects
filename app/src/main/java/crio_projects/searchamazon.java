package crio_projects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchamazon {
    ChromeDriver driver;
    public searchamazon(){
        System.out.println("Constructor: TestCases");
        // WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public  void searchamazon(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.findElements(By.name("q")).clear();
        WebElement searchBox = driver.findElement(By.name("q")); // Find the search input element
        searchBox.sendKeys("Amazon");
        // driver.findElements(By.name("q")).sendKeys("amazon");
        searchBox.sendKeys(Keys.ENTER);
        boolean res = driver.findElement(By.xpath("(//a[@href='https://www.amazon.in/'])[1]")).isDisplayed();
        System.out.println(res);
    }
}