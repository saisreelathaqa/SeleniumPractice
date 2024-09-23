package sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String parentHandle = driver.getWindowHandle();
        System.out.println("parent handle......."+parentHandle);//storing parent window handle


        //case 1 : opens new window, enter some values, close the current window and switchback to parent window

        driver.findElement(By.id("newWindowBtn")).click();
        Set<String> handles = driver.getWindowHandles(); // first value in the set is parent window value i.e index 0;
        for (String s : handles) {
            System.out.println(s);
            if (!s.equals(parentHandle)) {
                driver.switchTo().window(s);
                driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Sai");
                driver.findElement(By.xpath("//*[contains(@id, 'lastName')]")).sendKeys("sree");
                Thread.sleep(5000);
                driver.close(); // it closes current focus window
            }
        }
        driver.switchTo().window(parentHandle); // switchback to parent window
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("latha");
        Thread.sleep(5000);
        //driver.quit(); //it quits from browser


        //case 2 : opens new tab and switch back to parent window

        driver.findElement(By.xpath("//*[@id='newTabBtn']")).click();
        Set<String> handle1 = driver.getWindowHandles();
        for(String s : handle1){
            System.out.println("in loop...."+s);
            if(!s.equals(parentHandle)){
                System.out.println(driver.getTitle());
                driver.switchTo().window(s);
                System.out.println(driver.getTitle());
                //code for alert popup
                driver.findElement(By.xpath("//*[@id='alertBox']")).click();
                Thread.sleep(2000);
                Alert alert = driver.switchTo().alert();
                System.out.println(alert.getText());
                Thread.sleep(2000);
                alert.accept();

                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("_K");
        Thread.sleep(5000);


        //Case 3: open multiple(3) windows and switching to and fro

        driver.findElement(By.xpath("//*[contains(text(),'Open Multiple Windows')]")).click();
        Set<String> handle2 = driver.getWindowHandles();
        for(String s: handle2){
            if(!s.equals(parentHandle)){
                driver.switchTo().window(s);
                driver.manage().window().maximize();
                System.out.println(driver.getTitle());
                if(driver.getTitle().equals("XPath Practice - H Y R Tutorials")){
                    driver.findElement(By.xpath("//div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[1]")).sendKeys("SivaPrakash");
                    driver.findElement(By.xpath("//div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[2]")).sendKeys("Koppisetty");
                    Thread.sleep(3000);
                    driver.close();
                }
                else {
                    driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Tweety");
                    driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Penguin");
                    Thread.sleep(3000);
                }
            }
            //driver.close();
        }
        driver.switchTo().window(parentHandle);
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("_ABC");
        Thread.sleep(2000);
        System.out.println("Last main window....");
        driver.quit();
    }
}
