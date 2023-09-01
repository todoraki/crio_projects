package crio_projects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class imdbratings {
    ChromeDriver driver;
    public  imdbratings(){
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
    public void imdbratings(){
        driver.get("https://www.imdb.com/chart/top");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        Select selectDropDownRating = new Select(dropDown);
        selectDropDownRating.selectByVisibleText("IMDb rating");
        
        List<WebElement> countMovieList = driver.findElements(By.xpath("//div[@data-testid='chart-layout-parent']/div[2]/div/ul/li"));
        int movieSize = countMovieList.size();
        System.out.println("movies are included in the table : "+movieSize);

        WebElement highestRating = driver.findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/span/div/span"));
        System.out.println("highest Rating is: "+highestRating.getText());

        WebElement dropDown1 = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        dropDown1.click();
        Select selectDropDownReleaseDate = new Select(dropDown1);
        selectDropDownReleaseDate.selectByIndex(3);
        WebElement oldMovie= driver.findElement(By.xpath("//div[@data-testid='chart-layout-parent']/div[2]/div/ul/li[250]"));
        System.out.println("Oldest movie on the list"+oldMovie.getText());
         
        WebElement recentMovie= driver.findElement(By.xpath("//div[@data-testid='chart-layout-parent']/div[2]/div/ul/li[1]"));
        System.out.println("Recent movie on the list"+ recentMovie.getText());

        String mostUserRatingMovie = driver.findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
        System.out.println(mostUserRatingMovie);
    }
}