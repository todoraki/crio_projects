package crio_projects;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class imageurls {
    ChromeDriver driver;
    public  imageurls(){
        System.out.println("constructor");
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

    public void imageurls(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List <WebElement> links = driver.findElements(By.xpath("//img[contains(@src,'https://assets-in.bmscdn.com/discovery-catalog/events/tr:w-400,h-600,bg-CCCCCC:w-400.0,h-660.0,cm-pad_resize,bg-000000,fo-top:oi-discovery-catalog')]"));
        for (WebElement movieElement : links) {
            String srcUrl = movieElement.getAttribute("src");
            System.out.println("Movie URL: " + srcUrl);
        }
        WebElement secondPremierItem = driver.findElement(By.id("https://in.bookmyshow.com/chennai/movies/the-silent-forest/ET00366720-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondPremierItem);
        
        WebElement movieNameElement = secondPremierItem.findElement(By.className("sc-7o7nez-0 iHsoLV"));
        String movieName = movieNameElement.getText();
        System.out.println("Movie Name: " + movieName);
        
        WebElement languageElement = secondPremierItem.findElement(By.className("sc-7o7nez-0 kHxEsI"));
        String language = languageElement.getText();
        System.out.println("Language: " + language);
    }
    
}
