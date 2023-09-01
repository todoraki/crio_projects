package crio_projects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class linkedinpost{
    ChromeDriver driver;

    public linkedinpost(){
        System.out.println("test case constructor");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    public void endtest(){
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void linkedinpost(){
            // naviagte to https://www.linkedin.com/ using get method  https://www.linkedin.com/
            driver.get("https://www.linkedin.com/");
            // click on email field Using Locator "ID" "session_key"
            WebElement email = driver.findElement(By.id("session_key"));
            // enter email_id Using Locator "ID" "session_key"
            email.click();
            email.sendKeys("rankerviggy1@gmail.com");
            // click on password Using Locator "ID" "session_password"
            WebElement password = driver.findElement(By.id("session_password"));
            // enter password Using Locator "ID" "session_password"
            password.click();
            password.sendKeys("redhairshanks");
            // click on sing in button Using Locator "XPath" //button[@data-id="sign-in-form__submit-btn"]
            driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
            // click on profile name on top left Using Locator "XPath" (//*[@href="/in/vighnesh-pm-3b7b8325b/"])[1]
            driver.findElement(By.xpath("(//*[@href=\'/in/vighnesh-pm-3b7b8325b/\'])[1]")).click();
            // click on number of people who viewed the profile Using Locator "XPath" (//*[@href="https://www.linkedin.com/me/profile-views"])[1]
            WebElement number = driver.findElement(By.xpath("(//*[@href=\'https://www.linkedin.com/me/profile-views\'])[1]"));
            number.click();
            // get the number and store it in a variable Using Locator "XPath" //p[@class="text-body-medium-bold pr1 text-heading-large"]
            WebElement viewed = driver.findElement(By.xpath("//p[@class=\'text-body-medium-bold pr1 text-heading-large\']"));
            String views = viewed.getText();
            System.out.println("the number of ppl viewd  "+ views);
        }
    }