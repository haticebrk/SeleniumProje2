package SeleniumProjee;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _05_Soru5 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement contactUs = driver.findElement(By.cssSelector("i[class='ion-md-mail']"));
        contactUs.click();

        WebElement name = driver.findElement(By.cssSelector("input[id='sender_name']"));
        name.sendKeys("hatice");

        WebElement email = driver.findElement(By.id("sender_email"));
        email.sendKeys("hb34@gmail.com");

        WebElement subject = driver.findElement(By.id("sender_subject"));
        subject.sendKeys("iframeler");

        WebElement message = driver.findElement(By.id("sender_message"));
        message.sendKeys("hic sevmedim");

        WebElement sendMessage = driver.findElement(By.id("send_message_button"));
        sendMessage.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();


        WebElement alert = driver.findElement(By.id("send_message_button"));
        Assert.assertTrue(alert.getText().contains("Send Message"));


        driverKapat();
    }

}
