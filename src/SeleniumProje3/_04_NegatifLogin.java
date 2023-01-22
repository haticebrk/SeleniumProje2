package SeleniumProje3;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _04_NegatifLogin extends BaseDriver {
 /*   Senaryo 4: Negatif Login Test
➢ Siteye gidin
➢ Login butonuna tıklayın
➢ Geçersiz email veya password giriniz
➢ Login butonuna tıklatınız ve login olamadığınızı doğrulayınız*/


    @Test
    public void negatifLogin() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.linkText("Log in"));
        Actions aksiyonlar = new Actions(driver);

        aksiyonlar.moveToElement(login).click().build().perform();
        WebElement email = driver.findElement(By.cssSelector("input[autofocus='autofocus']"));
        aksiyonlar.moveToElement(email).click().sendKeys("omer3452@gmail.com").build().perform();

        WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        aksiyonlar.moveToElement(password).click().sendKeys("123452Omer").build().perform();

        WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));

        new Actions(driver).moveToElement(loginBtn).click().build().perform();

        WebElement validation=driver.findElement(By.className("validation-summary-errors"));
        Assert.assertTrue("mesasiniz hatali",validation.getText().contains("Login was unsuccessful"));
        driverKapat();
    }
}
