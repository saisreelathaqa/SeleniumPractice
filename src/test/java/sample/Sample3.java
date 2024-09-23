package sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Sample3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String parentHandle = driver.getWindowHandle();
        System.out.println("parent handle......."+parentHandle);//storing parent window handle
        Thread.sleep(5000);

        // handling 3 windows
        driver.findElement(By.xpath("//*[contains(text(),'Open Multiple Windows')]")).click();
        Set<String> handle2 = driver.getWindowHandles();
        for(String s: handle2){
            if(!s.equals(parentHandle)){
                driver.switchTo().window(s);
                System.out.println(driver.getTitle());
                if(driver.getTitle().equals("XPath Practice - H Y R Tutorials")){
                    driver.findElement(By.xpath("//div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[1]")).sendKeys("SivPrakash");
                    driver.findElement(By.xpath("//div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[2]")).sendKeys("Koppisetty");
                    Thread.sleep(3000);
                    //driver.close();
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
