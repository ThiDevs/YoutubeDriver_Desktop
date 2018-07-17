package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Teste {
	static List<String> Link_Videos = new ArrayList<String>();
	public static void main(String[] args) throws InterruptedException, IOException {
		
		String Path = "E:\\chromedriver.exe";
		//Path = "\\\\vix-gr-010\\D\\chromedriver.exe";
		//Path = "C:\\Users\\redes\\Desktop\\operadriver.exe";
		ChromeOptions options = new ChromeOptions();
		//options.setBinary("C:\\Program Files\\Opera\\launcher.exe");
		//System.setProperty("webdriver.chrome.driver",Path);
		//WebDriver driver = new OperaDriver(options);
		
		System.setProperty("webdriver.chrome.driver",Path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.youtube.com");
        
        
        Thread t = new Thread(() -> {
            try {
                ServerSocket Servidor = new ServerSocket(7878);

                do {
                    try {
                        Socket C = Servidor.accept();
                        Scanner s = new Scanner(C.getInputStream());
                        String pesquisar = s.nextLine();
                        
                        //if(pesquisar.length())
                        String[] Separa = pesquisar.split("@CodVIDEO==");
                        //System.out.println(Separa[1]);
                        		
                        		//);}
                        
                        if (pesquisar.equals("@Cod==1")) {

                        	Link_Videos.clear();
                            WebElement ok = driver.findElement(By.id("search-icon-legacy"));
                            ok.click();
                            Thread.sleep(3000);

                            String Title_Videos = "";
                            String Thumb_Videos = "";
                            

                            for (int i = 1; i < 21; i++) {
                                try {
                                    WebElement Videos = driver.findElement(By.xpath("//*[@id=\"contents\"]/ytd-video-renderer[" + i + "]"));
                                    WebElement InfosVideos = Videos.findElement(By.id("dismissable"));

                                    Title_Videos += ";" + InfosVideos.findElement(By.id("title-wrapper")).getText();


                                    Thumb_Videos += ";" + InfosVideos.findElement(By.id("img")).getAttribute("src");
                                    
                                    Link_Videos.add(InfosVideos.findElement(By.id("thumbnail")).getAttribute("href"));
                                    
                                    
                                } catch (Exception e) {
                                    //e.printStackTrace();
                                }
                            }
                            System.out.println(Title_Videos);
                            System.out.println(Thumb_Videos);
                            System.out.println(Link_Videos);
                            try {
                            	ServerSocket Servidor2 = new ServerSocket(7879);
                            	Socket C2 = Servidor2.accept();
                                PrintWriter writer = new PrintWriter(C2.getOutputStream());
                                writer.write(Title_Videos+"\n");
                                writer.write(Thumb_Videos);
                                writer.flush();
                                
                                writer.close();
                            } catch (Exception e) {

                            }
                        }else if (((pesquisar.length() > 10) && pesquisar.substring(0, 11).equals("@CodVIDEO==")) ) {
                        	int index = Integer.parseInt(Separa[1]);
                        	System.out.println(Separa[1]);                        	
                        	//System.out.println();
                        	driver.navigate().to(Link_Videos.get(index));
                        	driver.findElement(By.id("//*[@id=\"movie_player\"]/div[28]/div[2]/div[2]/button[6]"));
                        
                        	
                        }
                        else {
                            WebElement element = driver.findElement(By.id("search"));
                            System.out.println(pesquisar);
                            driver.findElement(By.id("search")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            element.sendKeys(pesquisar);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } while (true);
            } catch (IOException  e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        t.start();
	       
	}

}
