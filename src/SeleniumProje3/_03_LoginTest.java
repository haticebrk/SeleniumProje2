package SeleniumProje3;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _03_LoginTest extends BaseDriver {
  /*  Senaryo 3: Login Test
➢ Siteye gidin
➢ Login butonuna tıklayın
➢ Geçerli email ve password I giriniz
➢ Login butonuna tıklatınız ve login olduğunuzu doğrulayınız*/
    @Test
    public void Login(){
        driver.get("http://demowebshop.tricentis.com/");
        WebElement login=driver.findElement(By.linkText("Log in"));
        Actions aksiyonlar =new Actions(driver);

        aksiyonlar.moveToElement(login).click().build().perform();
       WebElement email=driver.findElement(By.cssSelector("input[autofocus='autofocus']"));
        aksiyonlar.moveToElement(email).click().sendKeys("omer3452@gmail.com").build().perform();

        WebElement password=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        aksiyonlar.moveToElement(password).click().sendKeys("123452Omer").build().perform();

        WebElement loginBtn=driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));

     new Actions(driver).moveToElement(loginBtn).click().build().perform();// burada yukaridakiler gibi kullaninca stale hatasi verdi newlweyince duzeldi
       WebElement varification=driver.findElement(By.linkText("omer345@gmail.com"));
        Assert.assertTrue("basarili giris yapamadiniz",varification.getText().equalsIgnoreCase("omer344@gmail.com"));
        driverKapat();
    }

}
