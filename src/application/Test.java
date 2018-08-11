package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws InterruptedException, IOException {
        String Path = "C:\\Users\\redes\\Desktop\\chromedriver.exe";
        Path =  "C:\\Users\\Thiago\\Desktop\\chromedriver.exe";
        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver",Path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/results?search_query=meu+mundo");
        String a = "" ;
        for (int i = 1; i < 21; i++) {
            try {
                WebElement Videos = driver.findElement(By.xpath("//*[@id=\"contents\"]/ytd-video-renderer[" + i + "]"));
                WebElement InfosVideos = Videos.findElement(By.id("dismissable"));
                //System.out.println(InfosVideos.findElement(By.id("description-text")).getText());

                //System.out.println(InfosVideos.findElement(By.id("byline")).getText());
               // System.out.println(InfosVideos.findElement(By.id("metadata-line")).getText());
                a = InfosVideos.findElement(By.id("metadata-line")).getText();
                String[] b = a.split("\n");
                System.out.println(b[0]+" "+ b[1]);





            } catch (Exception e){

            }

        }

        driver.quit();

    }
}
