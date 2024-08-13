package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Listpractice {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebElement ele = driver.findElement(By.xpath(""));
        String option = "8 years";
        List<WebElement> lstelemnts = ele.findElements(By.tagName("li"));
        for (WebElement item : lstelemnts) {
            if (item.getText().contains(option)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }
    }
}
