package sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Naukri_Home {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@title, 'Jobseeker Register')]")));

        driver.findElement(By.xpath("//a[contains(@title, 'Jobseeker Register')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("usernameField")).sendKeys("saisreelatha.qa@gmail.com");
        driver.findElement(By.id("passwordField")).sendKeys("Activate@1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("(//*[contains(@class, 'nI-gNb-menuItems__anchorDropdown')])[1]")).click();



        driver.findElement(By.xpath("//*[contains(text(),'Search jobs here')]")).click();
        driver.findElement(By.xpath("(//*[@class='suggestor-input '])[1]")).sendKeys("Selenium Automation Testing");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='experienceDD']")).click();
        Thread.sleep(2000);

        //        WebElement ele1 = driver.findElement(By.xpath("//*[@class='dropdownPrimary']"));

//     WebDriverWait wait = new WebDriverWait(driver, 10);
        //   WebElement ulElement = wait.until(
        //         ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='dropdown ']")));

        WebElement ulElement = driver.findElement(By.xpath("//*[@class='dropdown ']"));

        //option to choose
        String optionText = "7 years";

        List<WebElement> listItems = ulElement.findElements(By.tagName("li"));

        for (WebElement item : listItems) {
            if (item.getText().contains(optionText)) {
                // Scroll the item into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                // Take screenshot
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
                // Click the item
                item.click();
                break;
            }
        }


        driver.findElement(By.xpath("//div[3]/div[2]/div[1]/div/div/div[6]/div/div/div/input")).sendKeys("Hyderabad");

        //    WebElement city = wait.until(
        //          ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='pre-wrap' and contains(text(),'Hyder')]")));

        Thread.sleep(3000);
        WebElement city = driver.findElement(By.xpath("//*[@class='pre-wrap' and contains(text(),'Hyder')]"));
        city.click();

        driver.findElement(By.xpath("//*[@class='ni-gnb-icn ni-gnb-icn-search']")).click();
        Thread.sleep(3000);


        // print company names

//        WebElement ele1= driver.findElement(By.xpath("//*[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']"));
//        List<WebElement> listelemnts = ele1.findElements(By.xpath("//*[@class=' comp-name ' and contains(@class,' comp-name mw-25')]"));
//
//        for(WebElement companyName: listelemnts){
//
//            if(companyName.getText()!= null) {
//                System.out.println(companyName.getText());
//
//            }
//        }

        //print company names only
        int classSize = driver.findElements(By.xpath("//*[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple ']")).size();

        for (int i=1;i<=classSize;i++){

            String strCompany = driver.findElement(By.xpath("(//*[@class='cust-job-tuple layout-wrapper lay-2 sjw__tuple '])["+i+"]/div[2]/span/a[1]")).getText();

            System.out.println(strCompany);
        }
    }
}

//read data from column which has header as "Name" from excel.