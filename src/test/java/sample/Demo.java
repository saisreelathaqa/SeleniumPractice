package sample;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class Demo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.get("https://www.goibibo.com");
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[@class='sc-1f95z5i-51 hLPVfg']")).click();
        driver.findElement(By.xpath("//*[contains(@class,'loginCont__input')]")).sendKeys("9505966663");
        System.out.println("otp............");

        //driver.findElement(By.xpath("//*[contains(text(), 'I’ll do it later')]")).click();
        //System.out.println("after click..........");
        Thread.sleep(15000);
        //driver.findElement(By.xpath("//*[@class='sc-12foipm-36 hFZOAX']")).click();
        //driver.findElement(By.xpath("(//*[@class='sc-12foipm-20 bhnHeQ'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='sc-12foipm-6 erPfRs'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='sc-12foipm-25 fbAAhv']/input")).sendKeys("Visakhapatnam");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@class= 'sc-12foipm-29 gEpyDY'])[1]")).click();
        System.out.println("source....");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='sc-12foipm-25 fbAAhv']")).click();

        driver.findElement(By.xpath("//*[@class='sc-12foipm-25 fbAAhv']/input")).sendKeys("Hyderabad");
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@class='sc-12foipm-32 jVTqNw'])[1]")).click(); //selects first option
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@class='sc-12foipm-2 eTBlJr fswFld '])[3]")).click(); //clicks date calender
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[@class='fsw__price green'])[13]")).click(); //clicks on date
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[contains(text(), '1 Adult')]")).click();//clicks on Adults
        Thread.sleep(2000);


        driver.findElement(By.xpath("(//*[@class='sc-12foipm-51 kZvHQU'])[2]")).click(); //clicks on +
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@class='sc-12foipm-51 kZvHQU'])[4]")).click(); //clicks on child +
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='sc-12foipm-64 jkgFUQ']")).click(); //clicks on button
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@class='sc-12foipm-72 ezNmSh']")).click();
        Thread.sleep(20000);

        driver.close();

        }

}
