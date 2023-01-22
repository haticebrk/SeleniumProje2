package SeleniumProjee;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_Soru4 extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.xpath("/html/body/div[2]/div/div/a[2]"));
        eBook.click();


        WebElement addToCart = driver.findElement(By.xpath("//button[text()=' Add To Cart']"));
        addToCart.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']")));


        WebElement iframe1 = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
       driver.switchTo().frame(iframe1); //(  driver.switchTo().frame(5)  )

        WebElement usingDebitCart = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        usingDebitCart.click();



        WebElement frame = driver.findElement(By.cssSelector("div[id='Stripe-Element'] iframe"));
        driver.switchTo().frame(frame);


        WebElement cardNo = driver.findElement(By.cssSelector("input[placeholder='Card number']"));
        cardNo.sendKeys("4242 4242 4242 4242 12/22 000");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(5);
        WebElement Email=driver.findElement(By.cssSelector("input[placeholder='Email']"));
        Email.sendKeys("hburfa@gmail.com");

        WebElement confirmEmail=driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        confirmEmail.sendKeys("hburfa@gmail.com");

        WebElement nameOnCard=driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        nameOnCard.sendKeys("bahadir");

        WebElement phone=driver.findElement(By.cssSelector("input[autocomplete='phone']"));
        phone.sendKeys("056789054");

        WebElement company=driver.findElement(By.cssSelector("input[autocomplete='company']"));
        company.sendKeys("Visa");


        WebElement payButton= driver.findElement(By.xpath("//button[text()='Pay 0.50 USD']"));
        payButton.click();

        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.textToBe(By.xpath("//span[text()=' your order is confirmed. Thank you!']"),"your order is confirmed. Thank you!"));

        WebElement text=driver.findElement(By.xpath("//span[text()=' your order is confirmed. Thank you!']"));
        Assert.assertTrue(text.getText().contains("your order is confirmed. Thank you!"));
        driverKapat();



    }
}
