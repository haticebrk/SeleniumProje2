package SeleniumProje3;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _02_NegatifKayitTesti extends BaseDriver {
       /*  Senaryo 2: Negatif kayıt Testi
➢ Siteye gidin
➢ Register butonuna tıklayın
➢ Yukarda kaydolduğunuz email ile kayıt olmaya calisin
➢ Register butonuna tıkayınız
➢ “The specified email already exists” mesajının görüldüğünü doğrulayınız*/


    @Test
    public void negatifKatitTesti(){

        driver.get("http://demowebshop.tricentis.com/");
        WebElement register=driver.findElement(By.linkText("Register"));
        Actions aksiyonlar =new Actions(driver);

        aksiyonlar.moveToElement(register).click().build().perform();

        WebElement gender=driver.findElement(By.id("gender-female"));
        aksiyonlar.moveToElement(gender).click().build().perform();

        WebElement firstName=driver.findElement(By.id("FirstName"));
        aksiyonlar.moveToElement(firstName).click().sendKeys("Omer").build().perform();

        WebElement lastName=driver.findElement(By.id("LastName"));
        aksiyonlar.moveToElement(lastName).click().sendKeys("karaduman").build().perform();

        WebElement email=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        aksiyonlar.moveToElement(email).click().sendKeys("omer3452@gmail.com").build().perform();

        WebElement password=driver.findElement(By.id("Password"));
        aksiyonlar.moveToElement(password).click().sendKeys("123452Omer").build().perform();

        WebElement confirmPassword=driver.findElement(By.cssSelector("label[for='ConfirmPassword']"));
        aksiyonlar.moveToElement(confirmPassword).click().sendKeys("123452Omer").build().perform();

        WebElement ragisterBtn=driver.findElement(By.name("register-button"));
        aksiyonlar.moveToElement(ragisterBtn).click().build().perform();

        WebElement messsageVerification=driver.findElement(By.className("validation-summary-errors"));
        Assert.assertTrue("basarili mail girisi",messsageVerification.getText().equalsIgnoreCase("The specified email already exists"));
       driverKapat();
    }

}
