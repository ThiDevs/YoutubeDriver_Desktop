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
        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver",Path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/results?search_query=meu+mundo");
        for (int i = 1; i < 21; i++) {
            WebElement Videos = driver.findElement(By.xpath("//*[@id=\"contents\"]/ytd-video-renderer[" + i + "]"));
            WebElement InfosVideos = Videos.findElement(By.id("dismissable"));
            System.out.println(InfosVideos.findElement(By.id("description-text")).getText());

        }

    }
}
