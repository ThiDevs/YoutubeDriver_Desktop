package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException, IOException {
        String Path = "C:\\Users\\redes\\Desktop\\chromedriver.exe";
        //Path =  "C:\\Users\\Thiago\\Desktop\\chromedriver.exe";
        ChromeOptions options = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver",Path);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/watch?v=2HFexfq4Caw");






        driver.quit();

    }
}
