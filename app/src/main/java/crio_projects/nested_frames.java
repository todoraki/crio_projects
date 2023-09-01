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

public class nested_frames{
    ChromeDriver driver;
    public  nested_frames(){
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

    public void nested_frames(){

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to top frame
        driver.switchTo().frame("frame-top");

        // Switch to top left frame
        driver.switchTo().frame("frame-left");

        // Re-locate the body element within the current frame
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        String textFromTopLeftFrame = bodyElement.getText();
        System.out.println("Text from top left frame: " + textFromTopLeftFrame);

        // Switch back to parent frame
        driver.switchTo().parentFrame();

        // Switch to middle frame
        driver.switchTo().frame("frame-middle");

        // Re-locate the body element within the current frame
        String textFromMiddleFrame = bodyElement.getText();
        System.out.println("Text from middle frame: " + textFromMiddleFrame);

        // Switch back to parent frame
        driver.switchTo().parentFrame();

        // Switch to right frame
        driver.switchTo().frame("frame-right");

        // Re-locate the body element within the current frame
        String textFromRightFrame = bodyElement.getText();
        System.out.println("Text from right frame: " + textFromRightFrame);

        // Switch back to default content
        driver.switchTo().defaultContent();

        // Switch to bottom frame
        driver.switchTo().frame("frame-bottom");

        // Re-locate the body element within the current frame
        String textFromBottomFrame = bodyElement.getText();
        System.out.println("Text from bottom frame: " + textFromBottomFrame);
        }
    }