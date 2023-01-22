package SeleniumProjee;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _01_Soru1 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.xpath("/html/body/div[2]/div/div/a[2]"));
        eBook.click();


        WebElement addToCart = driver.findElement(By.xpath("//button[text()=' Add To Cart']"));
        addToCart.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //burada iframe locatorunu bulup gittim
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']")));

        driver.switchTo().frame(5);


        WebElement addPromoCode = driver.findElement(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']"));
        addPromoCode.click();


        WebElement promoCode = driver.findElement(By.cssSelector("[class='Promo-Code-Value']"));
        promoCode.sendKeys("XH45D");


        WebElement promoCodeClick = driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        promoCodeClick.click();


        wait.until(ExpectedConditions.textToBe(By.cssSelector("[id='SnackBar']>ion-icon+span"), "Invalid promo code"));

        WebElement invalidCodeconfirmation = driver.findElement(By.cssSelector("[id='SnackBar']>ion-icon+span"));
        Assert.assertTrue(invalidCodeconfirmation.getText().contains("Invalid promo code"));

        driverKapat();

    }

}
