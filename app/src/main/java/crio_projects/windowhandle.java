package crio_projects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandle {
    ChromeDriver driver;
    public  windowhandle(){
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
    public void windowhandle(){
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String currentWindow = driver.getWindowHandle();
        WebElement frame = driver.findElement(By.xpath("//*[@id='iframeResult']"));
        driver.switchTo().frame(frame);
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        clickButton.click();
        Set<String> allWindow = driver.getWindowHandles();
        for(String windowHal:allWindow){
            if(!windowHal.equals(currentWindow)){
                driver.switchTo().window(windowHal);
                String url = driver.getCurrentUrl();
                System.out.println(url);
                String title = driver.getTitle();
                System.out.println(title);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindow);
    }
}